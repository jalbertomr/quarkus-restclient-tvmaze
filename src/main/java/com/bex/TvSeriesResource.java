package com.bex;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.bex.model.Episode;
import com.bex.model.TvSerie;
import com.bex.proxy.EpisodeProxy;
import com.bex.proxy.TvSeriesProxy;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/tvseries")
public class TvSeriesResource {
	
	@RestClient
	TvSeriesProxy tvSeriesProxy;
	
	@RestClient
	EpisodeProxy episodeProxy;
	
	private List<TvSerie> tvSeries = new ArrayList<TvSerie>();
    
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("title") String title) {
		TvSerie tvSerie = tvSeriesProxy.get(title);
		List<Episode> episodes = episodeProxy.get(tvSerie.getId());
		tvSeries.add(tvSerie);
        return Response.ok(episodes).build();
    }
	

}
