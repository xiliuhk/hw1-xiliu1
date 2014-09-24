

/* First created by JCasGen Wed Sep 24 19:26:32 EDT 2014 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed Sep 24 19:26:32 EDT 2014
 * XML source: /home/minxiz/workspace/hw1-xiliu1/src/main/resources/descriptors/typeSystemDescriptor.xml
 * @generated */
public class sentence extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(sentence.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected sentence() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public sentence(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public sentence(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public sentence(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: source

  /** getter for source - gets 
   * @generated
   * @return value of the feature 
   */
  public String getSource() {
    if (sentence_Type.featOkTst && ((sentence_Type)jcasType).casFeat_source == null)
      jcasType.jcas.throwFeatMissing("source", "sentence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((sentence_Type)jcasType).casFeatCode_source);}
    
  /** setter for source - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setSource(String v) {
    if (sentence_Type.featOkTst && ((sentence_Type)jcasType).casFeat_source == null)
      jcasType.jcas.throwFeatMissing("source", "sentence");
    jcasType.ll_cas.ll_setStringValue(addr, ((sentence_Type)jcasType).casFeatCode_source, v);}    
   
    
  //*--------------*
  //* Feature: content

  /** getter for content - gets 
   * @generated
   * @return value of the feature 
   */
  public String getContent() {
    if (sentence_Type.featOkTst && ((sentence_Type)jcasType).casFeat_content == null)
      jcasType.jcas.throwFeatMissing("content", "sentence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((sentence_Type)jcasType).casFeatCode_content);}
    
  /** setter for content - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setContent(String v) {
    if (sentence_Type.featOkTst && ((sentence_Type)jcasType).casFeat_content == null)
      jcasType.jcas.throwFeatMissing("content", "sentence");
    jcasType.ll_cas.ll_setStringValue(addr, ((sentence_Type)jcasType).casFeatCode_content, v);}    
  }

    