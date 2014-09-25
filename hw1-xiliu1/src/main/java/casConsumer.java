import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.TypeSystem;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.collection.base_cpm.CasObjectProcessor;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.resource.metadata.ProcessingResourceMetaData;
import org.apache.uima.util.ProcessTrace;

/**
 * File output the gene tag and its position
 *
 */
public class casConsumer extends CasConsumer_ImplBase implements CasObjectProcessor {

  private File outFile;

  private FileWriter writer;

  private HashMap<String, String> SentenceIDmap;

  /**
   * Initialize output file.
   */
  public void initialize() throws ResourceInitializationException {
    try {
      String outfilePath = (String) getUimaContext().getConfigParameterValue("OutputFile");
      outFile = new File(outfilePath.trim());
      writer = new FileWriter(outFile);
    } catch (Exception e) {
      throw new ResourceInitializationException(e);
    }
    SentenceIDmap = new HashMap<String, String>();
  }

  @Override
  public boolean isStateless() {
    // TODO Auto-generated method stub
    return false;
  }

  /**
   * @see org.apache.uima.collection.CasConsumer#getProcessingResourceMetaData()
   */
  @Override
  public ProcessingResourceMetaData getProcessingResourceMetaData() {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * @see org.apache.uima.collection.CasConsumer#batchProcessComplete(ProcessTrace)
   */
  @Override
  public void batchProcessComplete(ProcessTrace aTrace) throws ResourceProcessException,
          IOException {
    // TODO Auto-generated method stub

  }

  /**
   * @see org.apache.uima.collection.CasConsumer#collectionProcessComplete(ProcessTrace aTrace)
   */
  @Override
  public void collectionProcessComplete(ProcessTrace aTrace) throws ResourceProcessException,
          IOException {
    // TODO Auto-generated method stub

  }

  /**
   * convert CAS to text and output to file
   */
  public void processCas(CAS pCAS) throws ResourceProcessException {
    JCas pJCas;
    try {
      pJCas = pCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }
    try {
      // initialize a buffered writer
      BufferedWriter bufferedWriter = new BufferedWriter(writer);
      // initialize the map for sentence content
      FSIterator<Annotation> sentenceIterator = pJCas.getAnnotationIndex(sentence.type).iterator();
      // hash the sentences by sourceID and put the content into map
      while (sentenceIterator.hasNext()) {
        sentence SentenceTag = (sentence) sentenceIterator.get();
        SentenceIDmap.put(SentenceTag.getSource(), SentenceTag.getContent());
        sentenceIterator.moveToNext();
      }
      FSIterator<Annotation> geneIterator = pJCas.getAnnotationIndex(word.type).iterator();
      // iterate the gene tags and find their positions
      while (geneIterator.hasNext()) {
        word geneT = (word) geneIterator.next();
        String sContent = SentenceIDmap.get(geneT.getSource());
        // calculate proper positions in sentence for each gene term
        String contentTemp = sContent.substring(0, geneT.getBegin());
        int countInSentence = blankCount(contentTemp);
        int countInContent = blankCount(sContent.substring(geneT.getBegin(), geneT.getEnd()));
        int start = geneT.getBegin() - countInSentence;
        int end = geneT.getEnd() - countInSentence - countInContent - 1;
        bufferedWriter.write(geneT.getSource() + "|" + start + " " + end + "|" + geneT.getContent()
                + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * @see org.apache.uima.collection.CasConsumer#processCas(CAS[] aCASes)
   */
  @Override
  public void processCas(CAS[] aCASes) throws ResourceProcessException {
    // TODO Auto-generated method stub

  }

  /**
   * @see org.apache.uima.collection.CasConsumer#typeSystemInit(TypeSystem aTypeSystem)
   */
  @Override
  public void typeSystemInit(TypeSystem aTypeSystem) throws ResourceInitializationException {
    // TODO Auto-generated method stub

  }

  /**
   * count the numbers of blanks in a given string
   */
  private int blankCount(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        count++;
      }
    }
    return count;
  }
}
