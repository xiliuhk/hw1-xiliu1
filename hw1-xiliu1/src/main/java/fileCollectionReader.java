/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.File;
import java.io.IOException;

import org.apache.uima.cas.CAS;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.util.FileUtils;
import org.apache.uima.util.Progress;

/**
 * file collection reader: load input file
 */

public class fileCollectionReader extends CollectionReader_ImplBase {
  private File inputfile;

  private boolean isFirst = true;

  /**
   * initialize input path
   */
  public void initialize() {
    inputfile = new File((String) getConfigParameterValue("InputFile"));
  }

  /**
   * read data from input file and convert to CAS
   */
  public void getNext(CAS pCAS) throws IOException, CollectionException {
    JCas jcas;
    try {
      jcas = pCAS.getJCas();
    } catch (Exception e) {
      throw new CollectionException(e);
    }
    // convert text data to CAS
    String text = "";
    text = FileUtils.file2String(inputfile);
    jcas.setDocumentText(text);
  }

  /**
   * @see org.apache.uima.collection.CollectionReader#hasNext()
   */
  @Override
  public boolean hasNext() throws IOException, CollectionException {
    // TODO Auto-generated method stub
    if (isFirst) {
      isFirst = false;
      return true;
    }
    return false;
  }

  /**
   * @see org.apache.uima.collection.base_cpm.BaseCollectionReader#getProgress()
   */
  @Override
  public Progress[] getProgress() {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * @see org.apache.uima.collection.base_cpm.BaseCollectionReader#close()
   */
  @Override
  public void close() throws IOException {
    // TODO Auto-generated method stub
  }

}
