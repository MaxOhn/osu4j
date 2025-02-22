package com.oopsjpeg.osu4j;

import com.google.gson.JsonObject;
import com.oopsjpeg.osu4j.abstractbackend.LazilyLoaded;
import com.oopsjpeg.osu4j.backend.EndpointBeatmapSet;
import com.oopsjpeg.osu4j.backend.EndpointUsers;
import com.oopsjpeg.osu4j.backend.Osu;
import com.oopsjpeg.osu4j.util.Utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.ZonedDateTime;

public class OsuBeatmap extends OsuElement {
	private ApprovalState approved;
	private ZonedDateTime approvedDate;
	private ZonedDateTime lastUpdate;
	private String artist;
	private int beatmapID;
	private int beatmapSetID;
	private LazilyLoaded<OsuBeatmapSet> beatmapSet;
	private float bpm;
	private String creatorName;
	private LazilyLoaded<OsuUser> creator;
	private float difficultyrating;
	private float diffSize;
	private float diffOverall;
	private float diffApproach;
	private float diffDrain;
	private int hitLength;
	private String source;
	private Genre genre;
	private Language language;
	private String title;
	private int totalLength;
	private String version;
	private String fileMD5;
	private GameMode mode;
	private String[] tags;
	private int favouriteCount;
	private int playcount;
	private int passcount;
	private int maxCombo;

	public OsuBeatmap(Osu api) {
		super(api);
	}

	public OsuBeatmap(Osu api, JsonObject obj) {
		super(api);
		approved = ApprovalState.fromID(obj.get("approved").getAsInt());
		approvedDate = obj.get("approved_date").isJsonNull() ? null : Utility.parseDate(obj.get("approved_date").getAsString());
		lastUpdate = Utility.parseDate(obj.get("last_update").getAsString());
		artist = obj.get("artist").getAsString();
		beatmapID = obj.get("beatmap_id").getAsInt();
		beatmapSetID = obj.get("beatmapset_id").getAsInt();
		bpm = obj.get("bpm").getAsFloat();
		creatorName = obj.get("creator").getAsString();
		difficultyrating = obj.get("difficultyrating").isJsonNull() ? 0 : obj.get("difficultyrating").getAsFloat();
		diffSize = obj.get("diff_size").getAsFloat();
		diffOverall = obj.get("diff_overall").getAsFloat();
		diffApproach = obj.get("diff_approach").getAsFloat();
		diffDrain = obj.get("diff_drain").getAsFloat();
		hitLength = obj.get("hit_length").getAsInt();
		source = obj.get("source").getAsString();
		genre = Genre.fromID(obj.get("genre_id").getAsInt());
		language = Language.fromID(obj.get("language_id").getAsInt());
		title = obj.get("title").getAsString();
		totalLength = obj.get("total_length").getAsInt();
		version = obj.get("version").getAsString();
		fileMD5 = obj.get("file_md5").isJsonNull() ? null : obj.get("file_md5").getAsString();
		mode = GameMode.fromID(obj.get("mode").getAsInt());
		tags = obj.get("tags").getAsString().split(" ");
		favouriteCount = obj.get("favourite_count").getAsInt();
		playcount = obj.get("playcount").getAsInt();
		passcount = obj.get("passcount").getAsInt();
		maxCombo = obj.get("max_combo").isJsonNull() ? 0 : obj.get("max_combo").getAsInt();

		beatmapSet = getAPI().beatmapSets.getAsQuery(new EndpointBeatmapSet.Arguments(beatmapSetID))
				.asLazilyLoaded();
		creator = getAPI().users.getAsQuery(new EndpointUsers.ArgumentsBuilder(creatorName).build())
				.asLazilyLoaded();
	}

	public OsuBeatmap(OsuBeatmap other) {
		super(other);
		this.approved = other.approved;
		this.approvedDate = other.approvedDate;
		this.lastUpdate = other.lastUpdate;
		this.artist = other.artist;
		this.beatmapID = other.beatmapID;
		this.beatmapSetID = other.beatmapSetID;
		this.beatmapSet = other.beatmapSet;
		this.bpm = other.bpm;
		this.creatorName = other.creatorName;
		this.creator = other.creator;
		this.difficultyrating = other.difficultyrating;
		this.diffSize = other.diffSize;
		this.diffOverall = other.diffOverall;
		this.diffApproach = other.diffApproach;
		this.diffDrain = other.diffDrain;
		this.hitLength = other.hitLength;
		this.source = other.source;
		this.genre = other.genre;
		this.language = other.language;
		this.title = other.title;
		this.totalLength = other.totalLength;
		this.version = other.version;
		this.fileMD5 = other.fileMD5;
		this.mode = other.mode;
		this.tags = other.tags;
		this.favouriteCount = other.favouriteCount;
		this.playcount = other.playcount;
		this.passcount = other.passcount;
		this.maxCombo = other.maxCombo;
	}

	public ApprovalState getApproved() {
		return approved;
	}

	public ZonedDateTime getApprovedDate() {
		return approvedDate;
	}

	public ZonedDateTime getLastUpdate() {
		return lastUpdate;
	}

	public String getArtist() {
		return artist;
	}

	public int getID() {
		return beatmapID;
	}

	public int getBeatmapSetID() {
		return beatmapSetID;
	}

	public LazilyLoaded<OsuBeatmapSet> getBeatmapSet() {
		return beatmapSet;
	}

	public float getBPM() {
		return bpm;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public LazilyLoaded<OsuUser> getCreator() {
		return creator;
	}

	public float getDifficulty() {
		return difficultyrating;
	}

	public float getSize() {
		return diffSize;
	}

	public float getOverall() {
		return diffOverall;
	}

	public float getApproach() {
		return diffApproach;
	}

	public float getDrain() {
		return diffDrain;
	}

	public int getHitLength() {
		return hitLength;
	}

	public String getSource() {
		return source;
	}

	public Genre getGenre() {
		return genre;
	}

	public Language getLanguage() {
		return language;
	}

	public String getTitle() {
		return title;
	}

	public int getTotalLength() {
		return totalLength;
	}

	public String getVersion() {
		return version;
	}

	public String getFileMD5() {
		return fileMD5;
	}

	public GameMode getMode() {
		return mode;
	}

	public String[] getTags() {
		return tags;
	}

	public int getFavouriteCount() {
		return favouriteCount;
	}

	public int getFavoriteCount() {
		return favouriteCount;
	}

	public int getPlayCount() {
		return playcount;
	}

	public int getPassCount() {
		return passcount;
	}

	public int getMaxCombo() {
		return maxCombo;
	}

	public URL getURL() throws MalformedURLException {
		return new URL(Osu.BASE_URL + "/b/" + beatmapID);
	}

	public void setApproved(ApprovalState approved) {
		this.approved = approved;
	}

	public void setApprovedDate(ZonedDateTime approvedDate) {
		this.approvedDate = approvedDate;
	}

	public void setLastUpdate(ZonedDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setBeatmapID(int beatmapID) {
		this.beatmapID = beatmapID;
	}

	public void setBeatmapSetID(int beatmapSetID) {
		this.beatmapSetID = beatmapSetID;
	}

	public void setBeatmapSet(LazilyLoaded<OsuBeatmapSet> beatmapSet) {
		this.beatmapSet = beatmapSet;
	}

	public void setBpm(float bpm) {
		this.bpm = bpm;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public void setCreator(LazilyLoaded<OsuUser> creator) {
		this.creator = creator;
	}

	public void setDifficultyrating(float difficultyrating) {
		this.difficultyrating = difficultyrating;
	}

	public void setDiffSize(float diffSize) {
		this.diffSize = diffSize;
	}

	public void setDiffOverall(float diffOverall) {
		this.diffOverall = diffOverall;
	}

	public void setDiffApproach(float diffApproach) {
		this.diffApproach = diffApproach;
	}

	public void setDiffDrain(float diffDrain) {
		this.diffDrain = diffDrain;
	}

	public void setHitLength(int hitLength) {
		this.hitLength = hitLength;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTotalLength(int totalLength) {
		this.totalLength = totalLength;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setFileMD5(String fileMD5) {
		this.fileMD5 = fileMD5;
	}

	public void setMode(GameMode mode) {
		this.mode = mode;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public void setFavouriteCount(int favouriteCount) {
		this.favouriteCount = favouriteCount;
	}

	public void setPlaycount(int playcount) {
		this.playcount = playcount;
	}

	public void setPasscount(int passcount) {
		this.passcount = passcount;
	}

	public void setMaxCombo(int maxCombo) {
		this.maxCombo = maxCombo;
	}

	@Override
	public String toString() {
		return artist + " - " + title + " [" + version + "]";
	}
}
