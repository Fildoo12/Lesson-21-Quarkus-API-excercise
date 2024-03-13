package cz.spsmb.rest;

import cz.spsmb.dto.PersonDTO;
import cz.spsmb.model.Person;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import cz.spsmb.dao.PersonRepository;

import java.util.List;
import java.util.Optional;

@Path("/persons")
public class PersonResource {

    @Inject
    PersonRepository personRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response list() {
        List<Person> persons = personRepository.listAll();
        return Response.ok().entity(persons).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getById(@PathParam("id") Long id) {
        Person person = personRepository.findById(id);
        return Response.ok().entity(person).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteById(@PathParam("id") Long id) {
        personRepository.deleteById(id);
        return Response.ok().entity("ok").build();
    }

    @Transactional
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(PersonDTO personDTO){
        if (validateInput(personDTO)){
            Person person = new Person();
            person.setName(personDTO.getName());
            person.setAge(personDTO.getAge());

            personRepository.persist(person);
            return Response.ok().entity("ok").build();
        }
        return Response.status(400).entity("Invalid input").build();
    }
    private boolean validateInput(PersonDTO personDTO){
        return !(personDTO.getName().isEmpty());
    }


}
