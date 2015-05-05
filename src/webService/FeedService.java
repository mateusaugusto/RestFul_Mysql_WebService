package webService;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.ProjectManager;
import model.ProjectManagerChaT;

import com.google.gson.Gson;

import dto.FeedObjects;
import dto.FeedObjectsChat;

@Path("/ws")
public class FeedService {

	@GET
	@Path("/listParty")
	@Produces("application/json")
	public String feed() {
		String feeds = null;
		try {
			ArrayList<FeedObjects> feedData = null;
			ProjectManager projectManager = new ProjectManager();
			feedData = projectManager.GetFeeds();
			Gson gson = new Gson();
			System.out.println(gson.toJson(feedData));
			feeds = gson.toJson(feedData);

		} catch (Exception e) {
			System.out.println("error");
		}
		return feeds;
	}

	@GET
	@Path("/msg/{id_party}/{id_msg}")
	@Produces("application/json")
	public String feed(@PathParam("id_party") String id_party,
			@PathParam("id_msg") String id_msg) {
		String feeds = null;
		try {
			ArrayList<FeedObjectsChat> feedDataChat = null;
			ArrayList<FeedObjectsChat> feedDataChat2 = new ArrayList<FeedObjectsChat>();

			ProjectManagerChaT projectManagerChat = new ProjectManagerChaT();
			feedDataChat = projectManagerChat.GetFeeds();

			Gson gson = new Gson();
			// System.out.println(gson.toJson(feedData));
			for (int i = 0; i <= feedDataChat.size(); i++) {

				if ((feedDataChat.get(i).getId_festa().equals(id_party))
						&& (Integer.parseInt(feedDataChat.get(i).getId()) > Integer
								.parseInt(id_msg))) {

					feedDataChat2.add(feedDataChat.get(i));
					feeds = gson.toJson(feedDataChat2);

				}
			}
		} catch (Exception e) {
			System.out.println("ok");
		}
		
		return feeds;
	}
}
