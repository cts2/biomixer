/*******************************************************************************
 * Copyright (C) 2011 Lars Grammel 
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 *
 *    http://www.apache.org/licenses/LICENSE-2.0 
 *     
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.  
 *******************************************************************************/
package org.thechiselgroup.biomixer.client.services.term;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.thechiselgroup.biomixer.client.Concept;
import org.thechiselgroup.biomixer.client.core.resources.Resource;
import org.thechiselgroup.biomixer.server.core.util.IOUtils;
import org.thechiselgroup.biomixer.server.workbench.util.xml.StandardJavaXMLDocumentProcessor;

public class LightTermResponseWithoutRelationshipsParserTest {

    private LightTermResponseWithoutRelationshipsParser underTest;

    @Test
    public void parseResponse() throws Exception {
        String responseXML = IOUtils
                .readIntoString(LightTermResponseWithoutRelationshipsParserTest.class
                        .getResourceAsStream("term-service-light-norelationships.response"));

        Resource concept = underTest.parseConcept("44103", responseXML);

        assertThat(concept.getUri(), equalTo(Concept.toConceptURI("44103",
                "http://purl.bioontology.org/ontology/ICD10/O80-O84.9")));

        assertThat((String) concept.getValue(Concept.FULL_ID),
                equalTo("http://purl.bioontology.org/ontology/ICD10/O80-O84.9"));

        assertThat((String) concept.getValue(Concept.VIRTUAL_ONTOLOGY_ID),
                equalTo("44103"));

        assertThat((String) concept.getValue(Concept.LABEL),
                equalTo("Delivery"));
        assertThat((String) concept.getValue(Concept.TYPE), equalTo("class"));
        assertThat((String) concept.getValue(Concept.DEFINITION), equalTo(""));
    }

    @Test
    public void parseResponseContainingDefinition() throws Exception {
        Resource concept = underTest
                .parseConcept(
                        "1070",
                        IOUtils.readIntoString(LightTermResponseWithoutRelationshipsParserTest.class
                                .getResourceAsStream("term-service-light-definition.response")));

        assertThat(concept.getUri(), equalTo(Concept.toConceptURI("1070",
                "http://purl.org/obo/owl/GO#GO_0007569")));
        assertThat(
                (String) concept.getValue(Concept.DEFINITION),
                equalTo("Progression of the cell from its inception to the end of its lifespan."));
    }

    @Before
    public void setUp() throws ParserConfigurationException {
        underTest = new LightTermResponseWithoutRelationshipsParser(
                new StandardJavaXMLDocumentProcessor());
    }

}