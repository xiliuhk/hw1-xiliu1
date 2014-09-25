/* First created by JCasGen Wed Sep 24 19:26:32 EDT 2014 */

import org.apache.uima.cas.Feature;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.tcas.Annotation_Type;

/**
 * Updated by JCasGen Wed Sep 24 19:26:32 EDT 2014
 * 
 * @generated
 */
public class word_Type extends Annotation_Type {
  /**
   * @generated
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {
    return fsGenerator;
  }

  /** @generated */
  private final FSGenerator fsGenerator = new FSGenerator() {
    public FeatureStructure createFS(int addr, CASImpl cas) {
      if (word_Type.this.useExistingInstance) {
        // Return eq fs instance if already created
        FeatureStructure fs = word_Type.this.jcas.getJfsFromCaddr(addr);
        if (null == fs) {
          fs = new word(addr, word_Type.this);
          word_Type.this.jcas.putJfsFromCaddr(addr, fs);
          return fs;
        }
        return fs;
      } else
        return new word(addr, word_Type.this);
    }
  };

  /** @generated */
  @SuppressWarnings("hiding")
  public final static int typeIndexID = word.typeIndexID;

  /**
   * @generated
   * @modifiable
   */
  @SuppressWarnings("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("word");

  /** @generated */
  final Feature casFeat_source;

  /** @generated */
  final int casFeatCode_source;

  /**
   * @generated
   * @param addr
   *          low level Feature Structure reference
   * @return the feature value
   */
  public String getSource(int addr) {
    if (featOkTst && casFeat_source == null)
      jcas.throwFeatMissing("source", "word");
    return ll_cas.ll_getStringValue(addr, casFeatCode_source);
  }

  /**
   * @generated
   * @param addr
   *          low level Feature Structure reference
   * @param v
   *          value to set
   */
  public void setSource(int addr, String v) {
    if (featOkTst && casFeat_source == null)
      jcas.throwFeatMissing("source", "word");
    ll_cas.ll_setStringValue(addr, casFeatCode_source, v);
  }

  /** @generated */
  final Feature casFeat_content;

  /** @generated */
  final int casFeatCode_content;

  /**
   * @generated
   * @param addr
   *          low level Feature Structure reference
   * @return the feature value
   */
  public String getContent(int addr) {
    if (featOkTst && casFeat_content == null)
      jcas.throwFeatMissing("content", "word");
    return ll_cas.ll_getStringValue(addr, casFeatCode_content);
  }

  /**
   * @generated
   * @param addr
   *          low level Feature Structure reference
   * @param v
   *          value to set
   */
  public void setContent(int addr, String v) {
    if (featOkTst && casFeat_content == null)
      jcas.throwFeatMissing("content", "word");
    ll_cas.ll_setStringValue(addr, casFeatCode_content, v);
  }

  /**
   * initialize variables to correspond with Cas Type and Features
   * 
   * @generated
   * @param jcas
   *          JCas
   * @param casType
   *          Type
   */
  public word_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl) this.casType, getFSGenerator());

    casFeat_source = jcas.getRequiredFeatureDE(casType, "source", "uima.cas.String", featOkTst);
    casFeatCode_source = (null == casFeat_source) ? JCas.INVALID_FEATURE_CODE
            : ((FeatureImpl) casFeat_source).getCode();

    casFeat_content = jcas.getRequiredFeatureDE(casType, "content", "uima.cas.String", featOkTst);
    casFeatCode_content = (null == casFeat_content) ? JCas.INVALID_FEATURE_CODE
            : ((FeatureImpl) casFeat_content).getCode();

  }
}
