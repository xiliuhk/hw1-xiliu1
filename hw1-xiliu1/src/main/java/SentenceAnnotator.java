import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

/**
 * break the file into sentences record the position and content of each sentence Sentence: sentence
 * ID (source)+ sentence content
 */
public class SentenceAnnotator extends JCasAnnotator_ImplBase {

  /**
   * receive pJCas: the previous CAS Step 1. split the text input into sentences Step 2. split the
   * sentence into sourceID and contents Step 3. convert string to CAS exception:
   * AnalysisEngineProcessException
   */
  public void process(JCas pJCas) throws AnalysisEngineProcessException {
    System.out.println("Sentence Annotator");
    String text = pJCas.getDocumentText();
    String[] sentences = text.split("\\n");
    for (int i = 0; i < sentences.length; i++) {
      sentence senTag = new sentence(pJCas);
      String[] senContent = sentences[i].split(" ", 2);
      senTag.setSource(senContent[0]);
      senTag.setContent(senContent[1]);
      senTag.addToIndexes(pJCas);
    }
  }
}