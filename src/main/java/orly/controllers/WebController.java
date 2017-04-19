package orly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import orly.logic.RiderProfile;
import orly.logic.RiderProfileDAO;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController extends WebMvcConfigurerAdapter{
    @Autowired
    private RiderProfileDAO riderProfileDAO;


    @RequestMapping(value="/create")
    @ResponseBody
    public String create(String name, String nickname, int age) {
        try {
            RiderProfile riderProfile = new RiderProfile(name, nickname, age);
            riderProfileDAO.addRiderProfile(riderProfile);
        }
        catch (Exception ex) {
            return "Error creating the RiderProfile: " + ex.toString();
        }
        return "RiderProfile succesfully created!";
    }


    @RequestMapping(value="/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            RiderProfile riderProfile = riderProfileDAO.getById(id);
            riderProfileDAO.removeRiderProfile(riderProfile);
        }
        catch (Exception ex) {
            return "Error deleting the RiderProfile: " + ex.toString();
        }
        return "RiderProfile succesfully deleted!";
    }


    @RequestMapping(value="/get-by-name")
    @ResponseBody
    public String getByEmail(String name) {
        String riderProfileId;
        try {
            RiderProfile riderProfile = riderProfileDAO.getByName(name);
            riderProfileId = String.valueOf(riderProfile.getId());
        }
        catch (Exception ex) {
            return "RiderProfile not found: " + ex.toString();
        }
        return "The RiderProfile id is: " + riderProfileId;
    }


    @RequestMapping(value="/update")
    @ResponseBody
    public String updateName(long id, String name, String nickname, int age) {
        try {
            RiderProfile riderProfile = riderProfileDAO.getById(id);
            riderProfile.setName(name);
            riderProfile.setNickname(nickname);
            riderProfile.setAge(age);
            riderProfileDAO.updateRiderProfile(riderProfile);
        }
        catch (Exception ex) {
            return "Error updating the RiderProfile: " + ex.toString();
        }
        return "RiderProfile succesfully updated!";
    }


}
