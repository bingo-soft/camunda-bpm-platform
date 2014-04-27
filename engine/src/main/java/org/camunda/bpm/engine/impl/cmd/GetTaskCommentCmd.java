/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.camunda.bpm.engine.impl.cmd;

import java.io.Serializable;

import org.camunda.bpm.engine.ProcessEngineException;
import org.camunda.bpm.engine.impl.interceptor.Command;
import org.camunda.bpm.engine.impl.interceptor.CommandContext;
import org.camunda.bpm.engine.task.Comment;


/**
 * @author kristin.polenz@camunda.com
 */
public class GetTaskCommentCmd implements Command<Comment>, Serializable {

  private static final long serialVersionUID = 1L;
  protected String taskId;
  protected String commentId;

  public GetTaskCommentCmd(String taskId, String commentId) {
    this.taskId = taskId;
    this.commentId = commentId;
  }

  public Comment execute(CommandContext commandContext) {
    if(taskId == null) {
      throw new ProcessEngineException("taskId is null");
    }

    if(commentId == null) {
      throw new ProcessEngineException("commentId is null");
    }

    return commandContext
      .getCommentManager()
      .findCommentByTaskIdAndCommentId(taskId, commentId);
  }

}
