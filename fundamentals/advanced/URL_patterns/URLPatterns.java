package fundamentals.advanced.URL_patterns;

import java.util.regex.Pattern;

public class URLPatterns {

	public static final String[] BASIC_URL_INDICATORS = { "http://", "https://", "www.", "ftp://", ".com", ".org",
			".net", ".edu", ".gov", ".es" };

	public static final String[] SUSPICIOUS_SHORTENERS = { "bit.ly", "tinyurl", "t.co", "short", "ow.ly", "goo.gl" };

	public static final String[] SOCIAL_MEDIA_DOMAINS = { "facebook.com", "twitter.com", "instagram.com", "youtube.com",
			"linkedin.com", "tiktok.com" };

	public static final Pattern FULL_URL_REGEX = Pattern
			.compile("(?i)\\b(?:https?://|www\\.|ftp://)?[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(?:/[^\\s]*)?\\b");

	public static final Pattern EMAIL_REGEX = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b");

}
