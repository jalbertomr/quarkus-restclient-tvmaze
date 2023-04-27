package com.bex.proxy;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.bex.model.Episode;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * https://api.tvmaze.com/shows/52/episodes
 * @author bext
 *
 */
@Path("/shows")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface EpisodeProxy {
  
	@GET
	@Path("{id}/episodes")
	List<Episode> get(@PathParam("id") Long id);
}
