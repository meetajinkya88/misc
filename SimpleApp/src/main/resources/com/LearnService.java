import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/main")
public class LearnService {

	@Path("")
	@GET
	@Produces("text/html")
	public Response helloWorld() {
		
	return Response.status(200).entity("<html> " + "<title>" + "Hello Jersey" + "</title>"
        + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ").build();	
 
	}
}
