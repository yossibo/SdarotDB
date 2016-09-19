package sdarotdb.my.com.sdarotdb;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jbt on 9/18/2016.
 */
public class Sidra  implements Parcelable {

    String name;
    int episodes;

    public Sidra(String name, int episodes) {
        this.name = name;
        this.episodes = episodes;
    }

    protected Sidra(Parcel in) {
        name = in.readString();
        episodes = in.readInt();
    }

    public static final Creator<Sidra> CREATOR = new Creator<Sidra>() {
        @Override
        public Sidra createFromParcel(Parcel in) {
            return new Sidra(in);
        }

        @Override
        public Sidra[] newArray(int size) {
            return new Sidra[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(episodes);
    }
}
