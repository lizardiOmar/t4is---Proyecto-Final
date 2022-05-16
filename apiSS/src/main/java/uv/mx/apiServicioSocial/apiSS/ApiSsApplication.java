package uv.mx.apiServicioSocial.apiSS;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
