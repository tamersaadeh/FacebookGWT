/*
 * Copyright (C) 2010 deNormans
 * http://www.denormans.com/
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of deNormans ("Confidential Information"). You 
 * shall not disclose such Confidential Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with deNormans.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS" AND ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * DENORMANS OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.denormans.facebookgwt.api.client.graph.js;

import com.denormans.facebookgwt.api.client.common.FBDateTimeFormats;
import com.denormans.facebookgwt.api.client.common.js.FBJSObject;

import java.util.Date;

public class FBGraphObject extends FBJSObject {
  protected FBGraphObject() {
  }

  public final native String getID() /*-{
    return String(this.id);
  }-*/;

  public final native String getName() /*-{
    return this.name;
  }-*/;

  public final Date getCreatedTime() {
    return FBDateTimeFormats.parseDateTime(FBDateTimeFormats.RFC3339Format, getUpdatedTimeJS());
  }

  private native String getCreatedTimeJS() /*-{
    return this.created_time;
  }-*/;

  public final Date getUpdatedTime() {
    return FBDateTimeFormats.parseDateTime(FBDateTimeFormats.RFC3339Format, getUpdatedTimeJS());
  }

  private native String getUpdatedTimeJS() /*-{
    return this.updated_time;
  }-*/;
}
