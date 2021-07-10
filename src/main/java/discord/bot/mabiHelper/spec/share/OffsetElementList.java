package discord.bot.mabiHelper.spec.share;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
public class OffsetElementList<T> implements Iterable<T>, Serializable {
    private List<T> results;
    private int totalCount;

    protected OffsetElementList() {
        this.results = new ArrayList();
    }

    public OffsetElementList(int totalCount) {
        this();
        this.totalCount = totalCount;
    }

    public OffsetElementList(List<T> results, int totalCount) {
        this.results = results;
        this.totalCount = totalCount;
    }

    public Iterator<T> iterator() {
        return this.results.iterator();
    }

    public int size() {
        return this.results != null ? this.results.size() : 0;
    }

    public T get(int index) {
        return this.results != null ? this.results.get(index) : null;
    }

    public void add(T result) {
        this.results.add(result);
    }

    public boolean isEmpty() {
        return this.results == null || this.results.isEmpty();
    }
}