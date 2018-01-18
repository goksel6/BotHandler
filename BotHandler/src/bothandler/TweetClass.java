/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bothandler;

import java.util.ArrayList;

/**
 *
 * @author Köksal
 */
public class TweetClass implements Comparable<TweetClass>{
    private String hashtag;
	private ArrayList<String> yorum ;
        private double sezgiDegeri;
        
        public TweetClass(double sezgiDegeri, ArrayList<String> yorum, String hashtag) {
		super();
                this.sezgiDegeri = sezgiDegeri;
		this.hashtag = hashtag;		
                this.yorum= yorum;
                
	}

    
        public double getsezgiDegeri() {
		return sezgiDegeri;
	}

	public void setsezgiDegeri(int kutupDegeri) {
		this.sezgiDegeri = sezgiDegeri;
	}

	public String gethashtag() {
		return hashtag;
	}

	public void sethashtag(String hastag) {
		this.hashtag = hashtag;
	}
        public String getyorum() {
		return hashtag;
	}

        public void setyorum(String hastag) {
		this.hashtag = hashtag;
	}

	@Override
	public String toString() {
		return super.toString() + " --Twitter yorumu [yorum=" + yorum + ", kutupDegeri=" + sezgiDegeri + " , hashtag="+hashtag+ "]";
	}
        
    @Override
        public int compareTo(TweetClass compareTweet) {

              return Double.compare(((TweetClass)compareTweet).sezgiDegeri, this.sezgiDegeri);


	}
}
