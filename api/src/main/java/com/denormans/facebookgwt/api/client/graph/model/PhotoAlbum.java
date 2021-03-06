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

package com.denormans.facebookgwt.api.client.graph.model;

import com.denormans.facebookgwt.api.shared.graph.PhotoAlbumType;
import com.denormans.facebookgwt.api.shared.graph.PhotoAlbumTypes;
import com.denormans.facebookgwt.api.shared.graph.PrivacyType;
import com.denormans.facebookgwt.api.shared.graph.PrivacyTypes;

public class PhotoAlbum extends FBGraphObject {
  protected PhotoAlbum() {
  }

  public final native User getFrom() /*-{
    return this.from;
  }-*/;

  public final native String getDescription() /*-{
    return this.description
  }-*/;

  public final native String getLocation() /*-{
    return this.location;
  }-*/;

  public final native String getPageURL() /*-{
    return this.link;
  }-*/;

  public final native int getNumPhotos() /*-{
    return this.count || 0;
  }-*/;

  public final PhotoAlbumType getType() {
    return PhotoAlbumTypes.valueFromApiValue(getTypeJS());
  }

  private native String getTypeJS() /*-{
    return this.type;
  }-*/;

  public final PrivacyType getPrivacy() {
    return PrivacyTypes.valueFromApiValue(getPrivacyJS());
  }

  private native String getPrivacyJS() /*-{
    return this.privacy
  }-*/;
}
