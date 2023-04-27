package com.bex.proxy;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.bex.model.TvSerie;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

/**
 * https://api.tvmaze.com/singlesearch/shows?q=game%20of%20thrones
 * @author bext
 *
 */
@Path("/singlesearch")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface TvSeriesProxy {
     
	@GET
	@Path("/shows")
	TvSerie get(@QueryParam("q") String title);
	 
}
