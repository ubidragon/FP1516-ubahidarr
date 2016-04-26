//package fp.grados.tipos.test;
//
//import java.io.IOException;
//import java.nio.file.Paths;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import com.google.common.io.Files;
//
//public class MetodoEscritura {
//
//	public <T> void metodoEscritura(String nombreFichero) {
//		List <T> result = get<T>().stream().collect(Collectors.toList());
//		try{
//			Files.write(Paths.get(nombreFichero), result);
//		} catch (IOException e){
//			System.out.println("Error en la escritura del fichero");
//		}
//	}
//	
//}
