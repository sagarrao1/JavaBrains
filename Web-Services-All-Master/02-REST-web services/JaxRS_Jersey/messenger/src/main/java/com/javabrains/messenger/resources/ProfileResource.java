package com.javabrains.messenger.resources;

import java.util.List;

import com.javabrains.messenger.model.Profile;
import com.javabrains.messenger.service.ProfileService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/profiles")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class ProfileResource {
	
	ProfileService profileService = new ProfileService();

	@GET
	public List<Profile> getProfiles(){
		List<Profile> profiles = profileService.getProfiles();		
		for (Profile profile : profiles) {
			System.out.println(profile.getProfileName());
		}
		return profileService.getProfiles();		
	}
	
	@POST
	public Profile addprofile(Profile profile) {		
		return profileService.addProfile(profile);
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getprofile(@PathParam("profileName") String profileName) {
		return profileService.getProfile(profileName);
	}
		
	
	@PUT
	@Path("/{profileName}")
	public Profile updateprofile(@PathParam("profileName") String profileName, Profile profile) {
		profile.setProfileName(profileName);
		System.out.println(profile);
		return profileService.updateProfile(profile);
//		return profile;
	}

	@DELETE
	@Path("/{profileName}")
	public void removeprofile(@PathParam("profileName") String profileName) {
		profileService.removeProfile(profileName);
	}
}
