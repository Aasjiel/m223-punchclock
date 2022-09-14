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

import ch.zli.m223.model.Category;
import ch.zli.m223.service.CategoryService;

@Path("/categories")
@Tag(name = "Categories", description = "Handling of categories")
public class CategoryController {
    @Inject
    CategoryService categoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all categories.", description = "Returns a list of all categories.")
    public List<Category> index() {
        return categoryService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new Category.", description = "Creates a new Category and returns the newly added Category.")
    public Category create(Category category) {
       return categoryService.createEntry(category);
    }

    @DELETE
    @Operation(
        summary = "Deletes an Entry",
        description = "Deletes a specified Entry and returns not a single thing"
    )
    @Path("/{Id}")
    public void delete(Long Id) {
        categoryService.deleteEntry(Id);
    }

    @PUT
    public void update(Category category){
        categoryService.update(category);
    }

}
