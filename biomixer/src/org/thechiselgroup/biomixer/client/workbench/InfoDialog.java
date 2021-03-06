/*******************************************************************************
 * Copyright 2009, 2010 Lars Grammel 
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
package org.thechiselgroup.biomixer.client.workbench;

import org.thechiselgroup.biomixer.client.core.command.AsyncCommandExecutor;
import org.thechiselgroup.biomixer.client.dnd.windows.Branding;
import org.thechiselgroup.biomixer.client.workbench.feedback.FeedbackDialog;
import org.thechiselgroup.biomixer.client.workbench.feedback.FeedbackServiceAsync;

import com.google.inject.Inject;

public class InfoDialog extends FeedbackDialog {

    @Inject
    public InfoDialog(Branding branding, AsyncCommandExecutor executor,
            FeedbackServiceAsync feedbackService) {

        super("About", branding.getApplicationTitle(), branding
                .getAboutDialogContentHTML(), null, executor, feedbackService);
    }

    @Override
    public String getOkayButtonLabel() {
        return "Send feedback";
    }

}