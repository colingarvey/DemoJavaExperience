package net.colingarvey;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * REST API consumption example, and deserialization from a JSON-encoded HTTP response into a Java
 * object utilizing the popular Gson JSON library.
 */
public class GithubUser {
    public String login;
    public int id;
    public String node_id;
    public String avatar_url;
    public String gravatar_id;
    public String url;
    public String html_url;
    public String followers_url;
    public String gists_url;
    public String starred_url;
    public String subscriptions_url;
    public String received_events_url;
    public String type;
    public String blog;
    public String location;
    public String email;
    public String hireable;
    public String bio;
    public String twitter_username;
    public String public_repos;

    // Primary Constructor; inferred by the Gson library
    public GithubUser(
        String login,
        int id,
        String node_id,
        String avatar_url,
        String gravatar_id,
        String url,
        String html_url,
        String followers_url,
        String gists_url,
        String starred_url,
        String subscriptions_url,
        String received_events_url,
        String type,
        String blog,
        String location,
        String email,
        String hireable,
        String bio,
        String twitter_username,
        String public_repos
        ){
         this.login = login;
         this.id = id;
         this.node_id = node_id;
         this.avatar_url = avatar_url;
         this.gravatar_id = gravatar_id;
         this.url = url;
         this.html_url = html_url;
         this.followers_url = followers_url;
         this.gists_url = gists_url;
         this.starred_url = starred_url;
         this.subscriptions_url = subscriptions_url;
         this.received_events_url = received_events_url;
         this.type = type;
         this.blog = blog;
         this.location = location;
         this.email = email;
         this.hireable = hireable;
         this.bio = bio;
         this.twitter_username = twitter_username;
         this.public_repos = public_repos;
    }

    /**
     * Static method to instantiate this class from the Github.com API, provided a username as parameter.
     *
     * @param user Github.com username
     * @return Returns a GithubUser object which models a Github.com user profile
     */
    public static GithubUser GetUser(String user) {
        try {
            String urlString = String.format("https://api.github.com/users/%s", user);
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() != 200) {
                throw new Exception(Integer.toString(conn.getResponseCode()));
            }
            Scanner jsonScanner = new Scanner(url.openStream());
            StringBuilder jsonStr = new StringBuilder();

            while (jsonScanner.hasNext()) {
                jsonStr.append(jsonScanner.nextLine());
            }
            Type GithubUserType = new TypeToken<GithubUser>() {}.getType();
            Gson gson = new Gson();
            return gson.fromJson(jsonStr.toString(), GithubUserType);
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
        return null;
    }
    public static void main(String[] args) {
        GithubUser ghu = GithubUser.GetUser("colingarvey");
        System.out.println(ghu.id);
        System.out.println(ghu.login);
        System.out.println(ghu.avatar_url);
        System.out.println(ghu.blog);
    }
}
