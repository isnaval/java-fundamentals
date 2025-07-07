package java_core.strings.advanced.URL_patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class URLExtractor {

	public boolean hasBasicURLPatterns(String text) {
		String lowerText = text.toLowerCase();

		for (String pattern : URLPatterns.BASIC_URL_INDICATORS) {
			if (lowerText.contains(pattern)) {
				return true;
			}
		}
		return false;
	}

	public List<String> extractURLs(String text) {
		List<String> urls = new ArrayList<>();
		Matcher matcher = URLPatterns.FULL_URL_REGEX.matcher(text);

		while (matcher.find()) {
			urls.add(matcher.group().trim());
		}
		return urls;
	}

	public List<String> extractEmails(String text) {
		List<String> emails = new ArrayList<>();
		Matcher matcher = URLPatterns.EMAIL_REGEX.matcher(text);

		while (matcher.find()) {
			emails.add(matcher.group());
		}
		return emails;
	}

	public boolean containsSuspiciousShorteners(String text) {
		String lowerText = text.toLowerCase();

		for (String shortener : URLPatterns.SUSPICIOUS_SHORTENERS) {
			if (lowerText.contains(shortener)) {
				return true;
			}
		}
		return false;
	}

	public boolean containsSocialMedia(String text) {
		String lowerText = text.toLowerCase();

		for (String domain : URLPatterns.SOCIAL_MEDIA_DOMAINS) {
			if (lowerText.contains(domain)) {
				return true;
			}
		}
		return false;
	}

	public int countURLs(String text) {
		return extractURLs(text).size();
	}
}