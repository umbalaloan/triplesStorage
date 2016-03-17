package triple.extraction.obo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Triple;

import org.obolibrary.oboformat.model.Clause;
import org.obolibrary.oboformat.model.Frame;
import org.obolibrary.oboformat.model.OBODoc;
import org.obolibrary.oboformat.parser.OBOFormatParser;

public class TripleExtraction {
	
	
	public static void main(String[] args) throws FileNotFoundException {
		OBOFormatParser p = new OBOFormatParser();
			InputStream inStream =  new FileInputStream("data/skills_v2_obo2.owl");
//		File file = new File("data/skills_v2_obo2.owl");
			try {
				OBODoc oboDoc  = p.parse(new BufferedReader(new InputStreamReader(inStream)));
//				OBODoc oboDoc = p.parse(file);
				Iterator<Frame> itr = oboDoc.getInstanceFrames().iterator();
				while (itr.hasNext())
				{
					Frame frame = itr.next();
//					System.out.println(frame.getId() );
//					System.out.println(frame);
					Iterator<Clause> clauses = frame.getClauses().iterator();
					while (clauses.hasNext())
					{
						
						Clause clause = clauses.next();
						System.out.println( clause.getTag() + " ; " + clause.getValue() );
						
//						if (clause.getTag().equals(OboFormatTag.TAG_PROPERTY_VALUE.toString()))
//						{System.out.println("----------");
//							System.out.println( clause.getTag() + " ; " + clause.getValue() );
//						}
						
					}
				}
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public List<Triple> extractTriples(File file)
	{

		OBOFormatParser oboparser = new OBOFormatParser();
		String subject = "";
		String object = "";
		String predicate = "";
		try {
			OBODoc oboDoc = oboparser.parse(file);
			Iterator<Frame> itr = oboDoc.getTermFrames().iterator();
			while(itr.hasNext())
			{
				Frame frame = itr.next();
				Iterator<Clause> itrClause = frame.getClauses().iterator();
				while (itrClause.hasNext())
				{
					Clause clause = itrClause.next();
//					switch (clause.getTag().toString()) {
//					case OboFormatTag.TAG_IS_A:
//						
//						break;
//
//					default:
//						break;
//					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Triple>();
	}
}
