import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;
import com.aliasi.util.AbstractExternalizable;

/**
 * break the sentence into word tokens record the position and content of each token record the gene
 * mention and its position
 */

public class geneAnnotator extends JCasAnnotator_ImplBase {
  /**
   * use LingPipe pack receive pJCas: previous CAS Step 1. feed HMM a sentence to determine if it
   * contains a gene tag Step 2. record the gene tags into words Step 3. convert the gene tags
   * objects to CAS exception: AnalysisEngineProcessException
   */
  public void process(JCas pJCas) throws AnalysisEngineProcessException {
    System.out.println("GeneAnnotator");
    File chunkerFile = new File("src/main/resources/data/ne-en-bio-genetag.HmmChunker");
    // HMM chunker to identify gene mentions
    Chunker HMMchunker;
    try {
      HMMchunker = (Chunker) AbstractExternalizable.readObject(chunkerFile);
      FSIterator<Annotation> iterator = pJCas.getAnnotationIndex(sentence.type).iterator();
      while (iterator.hasNext()) {
        sentence senTag = (sentence) iterator.next();
        String content = senTag.getContent();
        Chunking chunking = HMMchunker.chunk(content);
        Set<Chunk> chunkSet = chunking.chunkSet();
        for (Chunk chunk : chunkSet) {
          if (chunk != null) {
            word gene = new word(pJCas);
            gene.setSource(senTag.getSource());
            gene.setBegin(chunk.start());
            gene.setEnd(chunk.end());
            gene.setContent(content.substring(chunk.start(), chunk.end()));
            gene.addToIndexes();
          }
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

  }
}
