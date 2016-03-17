package triple.extraction.owl;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.vocab.OWLRDFVocabulary;

public class TripleExtraction {
	public static void main(String[] args) {
		 OWLOntologyManager m = OWLManager.createOWLOntologyManager();
		 File file = new File("data/pizza.owl");
		 try {
			OWLOntology owl = m.loadOntologyFromOntologyDocument(file);
			IRI documentIRI = m.getOntologyDocumentIRI(owl);
			System.out.println(documentIRI);
			OWLDataFactory factory = m.getOWLDataFactory();
//			factory.ge
			OWLClass cls = factory.getOWLClass(documentIRI);
			System.out.println(cls);
//			factory.
			Set <OWLClass> classes = owl.getClassesInSignature();
			for (OWLClass cl :classes)
			{
//				Iterator<String> itr = cl.getClass().
//				OWLEntity entity = cl.get
			}
			String individual = OWLRDFVocabulary.OWL_INDIVIDUAL.getShortForm();
			System.out.println(individual);
			
		} catch (OWLOntologyCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
