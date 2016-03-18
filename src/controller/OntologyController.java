package controller;

import java.io.File;
import java.io.StringWriter;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;

import util.OWLClassUtil;

import com.google.gson.stream.JsonWriter;

public class OntologyController {
	public static void main(String[] args) throws Exception {
		OntologyController con = new OntologyController();
		System.out.println(con.getClassHierary());
//		String json = con.getClassHierary();
//		DataObject obj = gson.fromJson(DataObject.class);
//		JsonReader reader = new JsonReader(new)
		
	}
	
	public String getClassHierary() throws Exception{
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		File file = new File("data/skills_version2.owl");
		OWLOntology ontology;
			ontology = manager.loadOntologyFromOntologyDocument(file);
			IRI docIRI = manager.getOntologyDocumentIRI(ontology);
			final OWLDataFactory factory = manager.getOWLDataFactory();
			final OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
			final OWLReasoner reasoner = reasonerFactory
					.createReasoner(ontology);
			final OWLClass owlThingClass = factory.getOWLThing(); // get root of class
			final StringWriter out = new StringWriter();
			final JsonWriter writer = new JsonWriter(out);
			OWLClassUtil.buildOWLClassHierarchy(writer, reasoner, factory, ontology, owlThingClass);
			writer.close();
		return out.toString() ;
	}

}
