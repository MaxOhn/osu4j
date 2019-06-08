package com.oopsjpeg.osu4j;

import com.google.gson.JsonObject;
import com.oopsjpeg.osu4j.abstractbackend.LazilyLoaded;
import com.oopsjpeg.osu4j.backend.EndpointBeatmaps;
import com.oopsjpeg.osu4j.backend.EndpointUsers;
import com.oopsjpeg.osu4j.backend.Osu;
import com.oopsjpeg.osu4j.util.Utility;

import java.time.ZonedDateTime;

public class OsuScore extends OsuElement {

	private int beatmapID = -1;
	private LazilyLoaded<OsuBeatmap> beatmap = null;
	private int score = -1;
	private int maxcombo = -1;
	private int count300 = -1;
	private int count100 = -1;
	private int count50 = -1;
	private int countmiss = -1;
	private int countkatu = -1;
	private int countgeki = -1;
	private boolean perfect = false;
	private GameMod[] enabledMods = new GameMod[0];
	private int userID = -1;
	private String username = "";
	private LazilyLoaded<OsuUser> user = null;
	private ZonedDateTime date = null;
	private String rank = "";
	private float pp = 0;

	public OsuScore(Osu api) {
		super(api);
	}

	public OsuScore(Osu api, JsonObject obj) {
		super(api);
		if (obj.has("beatmap_id")) beatmapID = obj.get("beatmap_id").getAsInt();
		if (obj.has("score")) score = obj.get("score").getAsInt();
		if (obj.has("maxcombo")) maxcombo = obj.get("maxcombo").getAsInt();
		if (obj.has("count300")) count300 = obj.get("count300").getAsInt();
		if (obj.has("count100")) count100 = obj.get("count100").getAsInt();
		if (obj.has("count50")) count50 = obj.get("count50").getAsInt();
		if (obj.has("countmiss")) countmiss = obj.get("countmiss").getAsInt();
		if (obj.has("countkatu")) countkatu = obj.get("countkatu").getAsInt();
		if (obj.has("countgeki")) countgeki = obj.get("countgeki").getAsInt();
		if (obj.has("perfect")) perfect = obj.get("perfect").getAsInt() == 1;
		if (obj.has("enabled_mods")) enabledMods = GameMod.get(obj.get("enabled_mods").getAsLong());
		if (obj.has("user_id")) userID = obj.get("user_id").getAsInt();
		if (obj.has("date")) date = Utility.parseDate(obj.get("date").getAsString());
		if (obj.has("rank")) rank = obj.get("rank").getAsString();
		if (obj.has("pp")) pp = obj.get("pp").isJsonNull() ? 0 : obj.get("pp").getAsFloat();

		if (beatmapID != -1)
			beatmap = getAPI().beatmaps.getAsQuery(new EndpointBeatmaps.ArgumentsBuilder()
				.setBeatmapID(beatmapID).build())
				.asLazilyLoaded().map(list -> list.get(0));

		if (userID != -1)
			user = getAPI().users.getAsQuery(new EndpointUsers.ArgumentsBuilder(userID).build())
				.asLazilyLoaded();
	}

	public OsuScore(OsuScore other) {
		super(other);
		this.beatmapID = other.beatmapID;
		this.beatmap = other.beatmap;
		this.score = other.score;
		this.maxcombo = other.maxcombo;
		this.count300 = other.count300;
		this.count100 = other.count100;
		this.count50 = other.count50;
		this.countmiss = other.countmiss;
		this.countkatu = other.countkatu;
		this.countgeki = other.countgeki;
		this.perfect = other.perfect;
		this.enabledMods = other.enabledMods;
		this.userID = other.userID;
		this.username = other.username;
		this.user = other.user;
		this.date = other.date;
		this.rank = other.rank;
		this.pp = other.pp;
	}

	public int getBeatmapID() {
		return beatmapID;
	}

	public LazilyLoaded<OsuBeatmap> getBeatmap() {
		return beatmap;
	}

	public int getScore() {
		return score;
	}

	public int getMaxCombo() {
		return maxcombo;
	}

	public int getHit300() {
		return count300;
	}

	public int getHit100() {
		return count100;
	}

	public int getHit50() {
		return count50;
	}

	public int getTotalHits() {
		return count300 + count100 + count50;
	}

	public int getMisses() {
		return countmiss;
	}

	public int getKatus() {
		return countkatu;
	}

	public int getGekis() {
		return countgeki;
	}

	public boolean isPerfect() {
		return perfect;
	}

	public GameMod[] getEnabledMods() {
		return enabledMods;
	}

	public int getUserID() {
		return userID;
	}

	public String getUsername() {
		return username;
	}

	public LazilyLoaded<OsuUser> getUser() {
		return user;
	}

	public ZonedDateTime getDate() {
		return date;
	}

	public String getRank() {
		return rank;
	}

	public float getPp() {
		return pp;
	}

	public void setBeatmapID(int beatmapID) {
		this.beatmapID = beatmapID;
	}

	public void setBeatmap(LazilyLoaded<OsuBeatmap> beatmap) {
		this.beatmap = beatmap;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setMaxcombo(int maxcombo) {
		this.maxcombo = maxcombo;
	}

	public void setCount300(int count300) {
		this.count300 = count300;
	}

	public void setCount100(int count100) {
		this.count100 = count100;
	}

	public void setCount50(int count50) {
		this.count50 = count50;
	}

	public void setCountmiss(int countmiss) {
		this.countmiss = countmiss;
	}

	public void setCountkatu(int countkatu) {
		this.countkatu = countkatu;
	}

	public void setCountgeki(int countgeki) {
		this.countgeki = countgeki;
	}

	public void setPerfect(boolean perfect) {
		this.perfect = perfect;
	}

	public void setEnabledMods(GameMod[] enabledMods) {
		this.enabledMods = enabledMods;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUser(LazilyLoaded<OsuUser> user) {
		this.user = user;
	}

	public void setDate(ZonedDateTime date) {
		this.date = date;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public void setPp(float pp) {
		this.pp = pp;
	}
}
