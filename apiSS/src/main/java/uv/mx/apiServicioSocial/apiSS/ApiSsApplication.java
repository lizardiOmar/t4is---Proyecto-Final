package uv.mx.apiServicioSocial.apiSS;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uv.mx.apiServicioSocial.apiSS.DB.Alumno;
import uv.mx.apiServicioSocial.apiSS.DB.Coordinador;

@RestController
@SpringBootApplication
public class ApiSsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSsApplication.class, args);
	}
	@RequestMapping(value="/coordinador/{token}", method=RequestMethod.GET)
	public String verCoordinador(@PathVariable String token){
		String response="Token no válido.";
		Coordinador c=Coordinador.getCoordinadorByToken(token);
		if(c!=null){
			response=c.toString();
		}
		return response;
	}
	@RequestMapping(value="/alumnos/{token}", method=RequestMethod.GET)
	public List<Alumno> verAlumnos(@PathVariable String token){
		List<Alumno>alumnos=null;
		Coordinador c=Coordinador.getCoordinadorByToken(token);
		if(c!=null){
			alumnos=Alumno.getAlumnosByCoordinador(c.getIdCoordinador());
		}
		return alumnos;
	}
	@PostMapping("/alumnos")
	public String registrarAlumnoPost(@RequestBody Alumno alumno, @RequestHeader String Authorization){
		String respuesta="Alumno "+alumno.getNombres()+" no registrado.";
		Coordinador c=Coordinador.getCoordinadorByToken(Authorization);
		if(c!=null){
			System.out.println("Token válido. Bienvenido coordinador "+c.getNombres());
			if(Alumno.registrarAlumno(alumno)){
				respuesta="Alumno "+alumno.getNombres()+" registrado.";
			}
		}else{
			respuesta="Token no válido.";
		}
		return respuesta;
	}

	@PutMapping("/actualizarToken/{idAlumno}")
	public String actualizarTokenPostAlumno(@PathVariable int idAlumno, @RequestHeader String Authorization){
		//Coordinador c=Coordinador.getCoordinadorByToken(Authorization);
		Coordinador c= new Coordinador();
		String respuesta = "Token no actualizado";
		if(c!=null){
			String validacion = Alumno.actualizarToken(idAlumno);
			if(validacion != null){
				System.out.println("Token válido. Bienvenido coordinador "+c.getNombres());
			}	
		}else{
			respuesta="Token no válido.";
		}
		return respuesta;
	}
}
