package triple.query.owl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFactory;
import org.apache.jena.query.ResultSetRewindable;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.vocabulary.OWL;
import org.apache.jena.vocabulary.RDFS;

public class TripleQuery {

	// Directory where we've stored the local data files, such as pizza.rdf.owl
	public static final String SOURCE = "data/";

	// Pizza ontology namespace
	public static final String PIZZA_NS = "http://www.co-ode.org/ontologies/pizza/pizza.owl#";

//	protected OntModel getModel() {
//		return ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
//	}

	public static void main(String[] args) throws FileNotFoundException {
		new TripleQuery().run();
	}
	public void run() throws FileNotFoundException {
//		OntModel m = getModel();
//		loadData(m);
		Model model=ModelFactory.createDefaultModel();
	    model.read(new FileInputStream("data/pizza.ttl"),null,"TTL");
		String prefix = "prefix pizza: <" + PIZZA_NS + ">\n" + "prefix rdfs: <"
				+ RDFS.getURI() + ">\n" + "prefix owl: <" + OWL.getURI()
				+ ">\n";

		showQuery(
				model,
				prefix
						+ "select ?pizza where {?pizza a owl:Class ; "
						+ "                            rdfs:subClassOf ?restriction.\n"
						+ "                     ?restriction owl:onProperty pizza:hasTopping ;"
						+ "                            owl:someValuesFrom pizza:PeperoniSausageTopping"
						+ "}");
	}

//	protected void loadData(Model m) {
//		FileManager.get().readModel(m, SOURCE + "pizza_ttl.owl");
//	}

	protected void showQuery(Model m, String q) {
		Query query = QueryFactory.create(q);
		QueryExecution qexec = QueryExecutionFactory.create(query, m);
		try {
			ResultSet results = qexec.execSelect();
//			ResultSetFormatter.out( results,m);
			ResultSetRewindable resultSetRewindable = ResultSetFactory.makeRewindable(results);
			int numCols = resultSetRewindable.getResultVars().size();
			for ( ; resultSetRewindable.hasNext() ; ) {
	            QuerySolution rBind = resultSetRewindable.nextSolution();
	            for ( int col = 0 ; col < numCols ; col++ ) {
	                String rVar = results.getResultVars().get(col);
	                System.out.println(rBind.getLiteral(rVar));
//	                row[col] = this.getVarValueAsString(rBind, rVar);
	            }
//	            printRow(pw, row, colWidths, colStart, colSep, colEnd);
	        }
			

		} finally {
			qexec.close();
		}

	}
}
