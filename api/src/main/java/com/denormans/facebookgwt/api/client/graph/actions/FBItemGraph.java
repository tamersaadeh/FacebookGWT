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

package com.denormans.facebookgwt.api.client.graph.actions;

import com.denormans.facebookgwt.api.client.FBGWTException;
import com.denormans.facebookgwt.api.client.FBIntegration;
import com.denormans.facebookgwt.api.client.graph.options.FBGraphCallOptions;
import com.denormans.facebookgwt.api.client.graph.model.FBGraphDataListResult;
import com.denormans.facebookgwt.api.client.graph.model.FBGraphObject;
import com.denormans.facebookgwt.api.client.graph.model.Account;
import com.denormans.facebookgwt.api.client.graph.model.Activity;
import com.denormans.facebookgwt.api.client.graph.model.Attachment;
import com.denormans.facebookgwt.api.client.graph.model.Book;
import com.denormans.facebookgwt.api.client.graph.model.CheckIn;
import com.denormans.facebookgwt.api.client.graph.model.Comment;
import com.denormans.facebookgwt.api.client.graph.model.Event;
import com.denormans.facebookgwt.api.client.graph.model.FriendList;
import com.denormans.facebookgwt.api.client.graph.model.Group;
import com.denormans.facebookgwt.api.client.graph.model.Insights;
import com.denormans.facebookgwt.api.client.graph.model.Interest;
import com.denormans.facebookgwt.api.client.graph.model.Link;
import com.denormans.facebookgwt.api.client.graph.model.Message;
import com.denormans.facebookgwt.api.client.graph.model.MessageThread;
import com.denormans.facebookgwt.api.client.graph.model.Movie;
import com.denormans.facebookgwt.api.client.graph.model.Music;
import com.denormans.facebookgwt.api.client.graph.model.Note;
import com.denormans.facebookgwt.api.client.graph.model.Page;
import com.denormans.facebookgwt.api.client.graph.model.Photo;
import com.denormans.facebookgwt.api.client.graph.model.PhotoAlbum;
import com.denormans.facebookgwt.api.client.graph.model.Post;
import com.denormans.facebookgwt.api.client.graph.model.Share;
import com.denormans.facebookgwt.api.client.graph.model.StatusMessage;
import com.denormans.facebookgwt.api.client.graph.model.Subscription;
import com.denormans.facebookgwt.api.client.graph.model.TelevisionShow;
import com.denormans.facebookgwt.api.client.graph.model.User;
import com.denormans.facebookgwt.api.client.graph.model.Video;
import com.denormans.facebookgwt.api.client.graph.options.FeedPostOptions;
import com.denormans.facebookgwt.api.shared.common.HTTPMethod;
import com.denormans.facebookgwt.api.shared.common.HTTPMethods;
import com.denormans.facebookgwt.api.shared.graph.ConnectionType;
import com.denormans.facebookgwt.api.shared.graph.ConnectionTypes;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public abstract class FBItemGraph<T extends FBGraphObject> extends FBIntegration {
  /**
   * Retrieves an item by ID.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  public void retrieveByID(final String itemID, final FBGraphCallOptions options, final AsyncCallback<T> callback) {
    executeGraphCall(itemID, null, null, HTTPMethods.Get, options, callback);
  }

  /**
   * Retrieves the given item's accounts.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveAccounts(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Account>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Accounts, options, callback);
  }

  /**
   * Retrieves the given item's activities.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveActivities(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Activity>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Activities, options, callback);
  }

  /**
   * Adds an activity to the item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void addActivity(final String itemID, final FBGraphCallOptions options, final AsyncCallback<Activity> callback) {
    post(itemID, ConnectionTypes.Activities, options, callback);
  }

  /**
   * Retrieves the given item's attachments.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveAttachments(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Attachment>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Books, options, callback);
  }

  /**
   * Adds an attachment to the item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void addAttachment(final String itemID, final FBGraphCallOptions options, final AsyncCallback<Attachment> callback) {
    post(itemID, ConnectionTypes.Attachments, options, callback);
  }

  /**
   * Retrieves the given item's books.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveBooks(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Book>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Books, options, callback);
  }

  /**
   * Adds a book to the item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void addBook(final String itemID, final FBGraphCallOptions options, final AsyncCallback<Book> callback) {
    post(itemID, ConnectionTypes.Books, options, callback);
  }

  /**
   * Retrieves the given item's events.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveCheckIns(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<CheckIn>> callback) {
    retrieveConnections(itemID, ConnectionTypes.CheckIns, options, callback);
  }

  /**
   * Adds a check-in to the item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void addCheckIn(final String itemID, final FBGraphCallOptions options, final AsyncCallback<CheckIn> callback) {
    post(itemID, ConnectionTypes.CheckIns, options, callback);
  }

  /**
   * Retrieves the given item's comments.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveComments(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Comment>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Comments, options, callback);
  }

  /**
   * Adds a comment to the item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void postComment(final String itemID, final FBGraphCallOptions options, final AsyncCallback<Comment> callback) {
    post(itemID, ConnectionTypes.Comments, options, callback);
  }

  /**
   * Retrieves the given item's events.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveEvents(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Event>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Events, options, callback);
  }

  /**
   * Adds a event to the item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void addEvent(final String itemID, final FBGraphCallOptions options, final AsyncCallback<Event> callback) {
    post(itemID, ConnectionTypes.Events, options, callback);
  }

  /**
   * Retrieves the given item's former participants.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveFormerParticipants(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<User>> callback) {
    retrieveConnections(itemID, ConnectionTypes.FormerParticipants, options, callback);
  }

  /**
   * Retrieves the given item's friends.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveFriends(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<User>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Friends, options, callback);
  }

  /**
   * Retrieves the given item's friend lists.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveFriendLists(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<FriendList>> callback) {
    retrieveConnections(itemID, ConnectionTypes.FriendLists, options, callback);
  }

  /**
   * Adds a friend list to the item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void addFriendList(final String itemID, final FBGraphCallOptions options, final AsyncCallback<FriendList> callback) {
    post(itemID, ConnectionTypes.FriendLists, options, callback);
  }

  /**
   * Retrieves the given item's groups.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveGroups(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Group>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Groups, options, callback);
  }

  /**
   * Adds a group to the item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void addGroup(final String itemID, final FBGraphCallOptions options, final AsyncCallback<Group> callback) {
    post(itemID, ConnectionTypes.Groups, options, callback);
  }

  /**
   * Retrieves the given item's home feed.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveHomeFeed(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Post>> callback) {
    retrieveConnections(itemID, ConnectionTypes.HomeFeed, options, callback);
  }

  /**
   * Retrieves the given item's inbox.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveInbox(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Note>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Inbox, options, callback);
  }

  /**
   * Retrieves the given item's insights.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveInsights(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Insights>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Insights, options, callback);
  }

  /**
   * Retrieves the given item's interests.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveInterests(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Interest>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Interests, options, callback);
  }

  /**
   * Adds an interest to the item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void addInterest(final String itemID, final FBGraphCallOptions options, final AsyncCallback<Interest> callback) {
    post(itemID, ConnectionTypes.Interests, options, callback);
  }

  /**
   * Retrieves the given item's invitees.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveInvitees(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<User>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Invited, options, callback);
  }

  /**
   * Retrieves the users that liked the given item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveLikedByUsers(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<User>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Likes, options, callback);
  }

  /**
   * Retrieves the given item's liked pages.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveLikedPages(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Page>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Likes, options, callback);
  }

  /**
   * Like the given item
   *
   * @param itemID The item ID
   * @param callback Called when complete
   */
  protected void like(final String itemID, final AsyncCallback<Boolean> callback) {
    post(itemID, ConnectionTypes.Likes, null, callback);
  }

  /**
   * Unlike the given item
   *
   * @param itemID The item ID
   * @param callback Called when complete
   */
  protected void unlike(final String itemID, final AsyncCallback<Boolean> callback) {
    deleteConnection(itemID, ConnectionTypes.Likes, null, callback);
  }

  /**
   * Retrieves the given item's links.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveLinks(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Link>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Links, options, callback);
  }

  /**
   * Posts a link to the item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void postLink(final String itemID, final FBGraphCallOptions options, final AsyncCallback<Link> callback) {
    post(itemID, ConnectionTypes.Links, options, callback);
  }

  /**
   * Retrieves the given item's maybes.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveMaybes(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<User>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Maybe, options, callback);
  }

  /**
   * Retrieves the given item's members.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveMembers(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<User>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Members, options, callback);
  }

  /**
   * Adds a member to the item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void addMember(final String itemID, final FBGraphCallOptions options, final AsyncCallback<User> callback) {
    post(itemID, ConnectionTypes.Members, options, callback);
  }

  /**
   * Retrieves the given item's messages.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveMessages(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Message>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Messages, options, callback);
  }

  /**
   * Retrieves the given item's movies.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveMovies(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Movie>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Movies, options, callback);
  }

  /**
   * Adds a movie to the item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void addMovie(final String itemID, final FBGraphCallOptions options, final AsyncCallback<Movie> callback) {
    post(itemID, ConnectionTypes.Movies, options, callback);
  }

  /**
   * Retrieves the given item's music.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveMusic(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Music>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Music, options, callback);
  }

  /**
   * Adds music to the item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void addMusic(final String itemID, final FBGraphCallOptions options, final AsyncCallback<Music> callback) {
    post(itemID, ConnectionTypes.Music, options, callback);
  }

  /**
   * Retrieves the given item's no-replies.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveNoReplies(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<User>> callback) {
    retrieveConnections(itemID, ConnectionTypes.NoReply, options, callback);
  }

  /**
   * Retrieves the given item's albums.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveNotes(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Note>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Notes, options, callback);
  }

  /**
   * Adds a note to the item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void addNote(final String itemID, final FBGraphCallOptions options, final AsyncCallback<Note> callback) {
    post(itemID, ConnectionTypes.Notes, options, callback);
  }

  /**
   * Retrieves the given item's outbox.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveOutbox(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Note>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Outbox, options, callback);
  }

  /**
   * Retrieves the given item's participants.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveParticipants(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<User>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Participants, options, callback);
  }

  /**
   * Retrieves the given item's albums.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrievePhotoAlbums(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<PhotoAlbum>> callback) {
    retrieveConnections(itemID, ConnectionTypes.PhotoAlbums, options, callback);
  }

  /**
   * Adds a photo album to the item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void addPhotoAlbum(final String itemID, final FBGraphCallOptions options, final AsyncCallback<PhotoAlbum> callback) {
    post(itemID, ConnectionTypes.PhotoAlbums, options, callback);
  }

  /**
   * Retrieves the given item's photos.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrievePhotos(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Photo>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Photos, options, callback);
  }

  /**
   * Posts a photo to the item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void postPhoto(final String itemID, final FBGraphCallOptions options, final AsyncCallback<Photo> callback) {
    post(itemID, ConnectionTypes.Photos, options, callback);
  }

  /**
   * Retrieves the given item's posts.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrievePosts(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Post>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Posts, options, callback);
  }

  /**
   * Retrieves the given item's senders.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveSenders(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<User>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Senders, options, callback);
  }

  /**
   * Retrieves the given item's shares.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveShares(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Share>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Shares, options, callback);
  }

  /**
   * Adds a share to the item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void addShare(final String itemID, final FBGraphCallOptions options, final AsyncCallback<Share> callback) {
    post(itemID, ConnectionTypes.Shares, options, callback);
  }

  /**
   * Retrieves the given item's status messages.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveStatusMessages(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<StatusMessage>> callback) {
    retrieveConnections(itemID, ConnectionTypes.StatusMessages, options, callback);
  }

  /**
   * Posts a status message to the item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void postStatusMessage(final String itemID, final FBGraphCallOptions options, final AsyncCallback<StatusMessage> callback) {
    post(itemID, ConnectionTypes.StatusMessages, options, callback);
  }

  /**
   * Retrieves the posts, photos and videos that the given item is subscriptions.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveSubscriptions(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Subscription>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Subscriptions, options, callback);
  }

  /**
   * Retrieves the given item's threads.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveMessageThreads(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<MessageThread>> callback) {
    retrieveConnections(itemID, ConnectionTypes.MessageThreads, options, callback);
  }

  /**
   * Retrieves the posts, photos and videos that the given item is tagged in.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveTaggedIn(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Post>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Tagged, options, callback);
  }

  /**
   * Retrieves the given item's television shows.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveTelevisionShows(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<TelevisionShow>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Television, options, callback);
  }

  /**
   * Adds a television show to the item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void addTelevisionShow(final String itemID, final FBGraphCallOptions options, final AsyncCallback<TelevisionShow> callback) {
    post(itemID, ConnectionTypes.Television, options, callback);
  }

  /**
   * Retrieves the given item's updates.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveUpdates(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Note>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Updates, options, callback);
  }

  /**
   * Retrieves the given item's videos.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveVideos(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Video>> callback) {
    retrieveConnections(itemID, ConnectionTypes.Videos, options, callback);
  }

  /**
   * Posts a video to the item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void postVideo(final String itemID, final FBGraphCallOptions options, final AsyncCallback<Video> callback) {
    post(itemID, ConnectionTypes.Videos, options, callback);
  }

  /**
   * Retrieves the given item's video uploads.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveVideoUploads(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Video>> callback) {
    retrieveConnections(itemID, ConnectionTypes.VideoUploads, options, callback);
  }

  /**
   * Retrieves the given item's wall feed.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  protected void retrieveWallFeed(final String itemID, final FBGraphCallOptions options, final AsyncCallback<List<Post>> callback) {
    retrieveConnections(itemID, ConnectionTypes.WallFeed, options, callback);
  }

  /**
   * Posts to the item's wall feed.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called when complete
   */
  protected void postToWall(final String itemID, final FeedPostOptions options, final AsyncCallback<Post> callback) {
    post(itemID, ConnectionTypes.WallFeed, options, callback);
  }

  /**
   * Retrieves an item's connections by ID.
   *
   * @param itemID The item ID
   * @param connectionType The type of connection to retrieve
   * @param options The call options
   * @param callback Called with the results
   */
  protected <G extends FBGraphObject> void retrieveConnections(final String itemID, final ConnectionType connectionType, final FBGraphCallOptions options, final AsyncCallback<List<G>> callback) {
    executeGraphCall(itemID, connectionType, null, HTTPMethods.Get, options, callback != null ? new FBGraphDataListTransformingCallback<G>(callback) : null);
  }

  /**
   * Post an item to the owner's feed/likes/etc.
   *
   * @param ownerID The owner item ID
   * @param connectionType The type of connection to post
   * @param options The call options
   * @param callback Called when complete
   */
  protected void post(final String ownerID, final ConnectionType connectionType, final FBGraphCallOptions options, final AsyncCallback<?> callback) {
    post(ownerID, connectionType, null, options, callback);
  }

  /**
   * Post an item to the owner's feed/likes/etc.
   *
   * @param ownerID The owner item ID
   * @param connectionType The type of connection to post
   * @param additionalPath The additional path information, if any
   * @param options The call options
   * @param callback Called when complete
   */
  protected void post(final String ownerID, final ConnectionType connectionType, final String additionalPath, final FBGraphCallOptions options, final AsyncCallback<?> callback) {
    executeGraphCall(ownerID, connectionType, additionalPath, HTTPMethods.Post, options, callback);
  }

  /**
   * Deletes the item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called when complete
   */
  public void delete(final String itemID, final FBGraphCallOptions options, final AsyncCallback<Boolean> callback) {
    executeGraphCall(itemID, null, null, HTTPMethods.Delete, options, callback);
  }

  /**
   * Deletes the unidentified connection (e.g. Like) for an item.
   *
   * @param itemID The item ID
   * @param connectionType The type of connection
   * @param options The call options
   * @param callback Called when complete
   */
  protected void deleteConnection(final String itemID, final ConnectionType connectionType, final FBGraphCallOptions options, final AsyncCallback<Boolean> callback) {
    deleteConnection(itemID, connectionType, null, options, callback);
  }

  /**
   * Deletes the unidentified connection (e.g. Like) for an item.
   *
   * @param itemID The item ID
   * @param connectionType The type of connection
   * @param additionalPath The additional path information, if any
   * @param options The call options
   * @param callback Called when complete
   */
  protected void deleteConnection(final String itemID, final ConnectionType connectionType, final String additionalPath, final FBGraphCallOptions options, final AsyncCallback<Boolean> callback) {
    executeGraphCall(itemID, connectionType, additionalPath, HTTPMethods.Delete, options, callback);
  }

  /**
   * Executes a Graph REST API method.
   *
   * @param objectID The object to retrieve from/post to
   * @param connectionType The type of connections (if any) to retrieve from the object
   * @param additionalPath Any additional path information, if any
   * @param httpMethod The HTTP method to use
   * @param options The call options
   * @param callback Called with the result
   */
  protected void executeGraphCall(final String objectID, final ConnectionType connectionType, final String additionalPath, final HTTPMethod httpMethod, final FBGraphCallOptions options, final AsyncCallback<?> callback) {
    executeWithFB(new Scheduler.ScheduledCommand() {
      @Override
      public void execute() {
        executeGraphCallJS(objectID, connectionType, additionalPath, httpMethod, options, callback);
      }
    });
  }

  private native void executeGraphCallJS(final String objectID, final ConnectionType connectionType, final String additionalPath, final HTTPMethod httpMethod, final FBGraphCallOptions options, final AsyncCallback<?> callback) /*-{
    try {
      var path = "/";

      if (objectID != null) {
        path += objectID;
      }

      if (connectionType != null) {
        path += "/" + connectionType.@com.denormans.facebookgwt.api.shared.graph.ConnectionType::getApiValue()();
      }

      if (additionalPath != null) {
        path += "/" + additionalPath;
      }

      var method = "get";
      if (httpMethod != null) {
        method = httpMethod.@com.denormans.facebookgwt.api.shared.common.HTTPMethod::getApiValue()();
      }

      var params = options;
      if (params == null) {
        params = {};
      }

      var cb;
      if (callback != null) {
        var self = this;
        cb = function(response) {
          if (typeof(response) === "boolean") {
            self.@com.denormans.facebookgwt.api.client.FBIntegration::executeCallback(Lcom/google/gwt/user/client/rpc/AsyncCallback;Z)(callback, response);
          } else if (typeof(response) === "number") {
            self.@com.denormans.facebookgwt.api.client.FBIntegration::executeCallback(Lcom/google/gwt/user/client/rpc/AsyncCallback;D)(callback, response);
          } else {
            if (response != null && response.error != null) {
              self.@com.denormans.facebookgwt.api.client.graph.actions.FBItemGraph::executeCallbackError(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/denormans/facebookgwt/api/client/graph/actions/FBGraphError;)(callback, response.error);
              return;
            }
            self.@com.denormans.facebookgwt.api.client.FBIntegration::executeCallback(Lcom/google/gwt/user/client/rpc/AsyncCallback;Ljava/lang/Object;)(callback, response);
          }
        };
      }

      $wnd.FB.api(path, method, params, cb);
    } catch(e) {
      if (callback != null) {
        var ex = @com.denormans.facebookgwt.gwtutil.client.js.JSError::createException(Ljava/lang/Object;)(e);
        callback.@com.google.gwt.user.client.rpc.AsyncCallback::onFailure(Ljava/lang/Throwable;)(ex);
      } else {
        throw e;
      }
    }
  }-*/;

  protected void executeCallbackError(final AsyncCallback callback, final FBGraphError error) {
    String message = error.getMessage();
    String type = error.getType();
    if (type != null && type.length() > 0) {
      message += " (" + type + ")";
    }

    FBGWTException fbgwtException = new FBGWTException(message);
    fbgwtException.fillInStackTrace();
    callback.onFailure(fbgwtException);
  }

  private static class FBGraphDataListTransformingCallback<G extends FBGraphObject> implements AsyncCallback<FBGraphDataListResult<G>> {
    private final AsyncCallback<List<G>> callback;

    public FBGraphDataListTransformingCallback(final AsyncCallback<List<G>> callback) {
      this.callback = callback;
    }

    @Override
    public void onFailure(final Throwable caught) {
      callback.onFailure(caught);
    }

    @Override
    public void onSuccess(final FBGraphDataListResult<G> result) {
      callback.onSuccess(result.getData());
    }
  }
}
