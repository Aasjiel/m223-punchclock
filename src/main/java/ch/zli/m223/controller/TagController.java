package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

// import ch.zli.m223.model.Tag;
import ch.zli.m223.service.TagService;

@Path("/tags")
@Tag(name = "Tags", description = "Handling of tags")
public class TagController {
    @Inject
    TagService tagService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all tags.", description = "Returns a list of all tags.")
    public List<ch.zli.m223.model.Tag> index() {
        return tagService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new entry.", description = "Creates a new entry and returns the newly added entry.")
    public ch.zli.m223.model.Tag create(ch.zli.m223.model.Tag tag) {
       return tagService.createEntry(tag);
    }

    @DELETE
    @Operation(
        summary = "Deletes an Entry",
        description = "Deletes a specified Entry and returns not a single thing"
    )
    @Path("/{Id}")
    public void delete(Long Id) {
        tagService.deleteEntry(Id);
    }

    @PUT
    public void update(ch.zli.m223.model.Tag tag){
        tagService.update(tag);
    }
}
