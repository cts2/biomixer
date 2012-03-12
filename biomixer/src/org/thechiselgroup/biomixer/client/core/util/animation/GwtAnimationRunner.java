/*******************************************************************************
 * Copyright (C) 2012 Lars Grammel 
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
package org.thechiselgroup.biomixer.client.core.util.animation;

public class GwtAnimationRunner implements AnimationRunner {

    @Override
    public void run(final Animation animation, int duration) {
        new com.google.gwt.animation.client.Animation() {
            @Override
            protected void onUpdate(double progress) {
                // JavaScriptObject insertFunction = DocumentFragmentUtil
                // .removeToInsertLater(domElement);
                animation.update(progress);
                // DocumentFragmentUtil.runFunction(insertFunction);
            }
        }.run(duration);
    }

}