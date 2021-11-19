package com.funsoft.cabinet.controller;


import com.funsoft.cabinet.model.Client;
import com.funsoft.cabinet.model.Medecin;
import com.funsoft.cabinet.model.Rv;
import com.funsoft.cabinet.repository.RvRepository;
import com.funsoft.cabinet.service.ClientService;
import com.funsoft.cabinet.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class RvRest {

    @Autowired
    RvRepository agent;

    @Autowired
    ClientService agentcl;

    @Autowired
    MedecinService agentmed;

    @RequestMapping(value = "/rdvs/add",method = RequestMethod.GET)
    public ModelAndView add_rdv(){
        Rv rdv = new Rv();
        List<Client> clients = agentcl.consulte();
        List<Medecin> medecins = agentmed.consulte();
        ModelAndView response = new ModelAndView();
        response.addObject("RdvForm",rdv);
        response.addObject("clients",clients);
        response.addObject("medecins",medecins);
        response.setViewName("rdv");
        return response;
    }
    @RequestMapping(value = "/rdvs/save",method = RequestMethod.POST)
    public ModelAndView save(@Valid @ModelAttribute("RdvForm") Rv rdv, BindingResult res){
        Medecin med = agentmed.getById(rdv.getMedecin().getId());
        rdv.setMedecin(med);
        Client client = agentcl.getById(rdv.getClient().getId());
        rdv.setClient(client);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date = LocalDateTime.parse(rdv.getSjour().replace("T"," "),formatter);
        rdv.setJour(date);
            agent.save(rdv);

        return new ModelAndView("redirect:/rdvs/list");

    }
    @RequestMapping(value = "rdvs/listJson",method = RequestMethod.GET)
    public ResponseEntity <Iterable<Rv>> liste_rdvjson(){
        return ResponseEntity.ok(agent.findAll());


    }
    @RequestMapping(value = "rdvs/list",method = RequestMethod.GET)
    public ModelAndView liste_rdv(){
        ModelAndView model = new ModelAndView();
        List<Rv> rdvs = (List<Rv>)agent.findAll();
        model.addObject("rdvs",rdvs);
        model.setViewName("rdvs");
        return model ;
    }
    @RequestMapping(value = "/rdvs/delete/{id}",method = RequestMethod.GET)
    public ModelAndView delete_client(@PathVariable("id") long id){

        agent.deleteById(id);
        return new ModelAndView("redirect:/rdvs/list");

    }

    @RequestMapping(value = "/rdvs/update/{id}",method = RequestMethod.GET)
    public ModelAndView update_doctor(@PathVariable("id") long id){
        Rv rv = agent.findById(id).get();
        List<Client> clients = agentcl.consulte();
        List<Medecin> medecins = agentmed.consulte();
        ModelAndView rep = new ModelAndView();
        rep.addObject("RdvForm",rv);
        rep.addObject("clients",clients);
        rep.addObject("medecins",medecins);
        rep.setViewName("rdv");
        return rep;
    }

}
