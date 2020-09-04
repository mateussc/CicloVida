package br.usjt.ads20.ciclovida;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StatusTracker {
    private List<String> mMethodList;
    private Map<String, String> mStatusMap;
    private static StatusTracker ourInstance = new StatusTracker();
    private static final String STATUS_SUFFIX = "ed";

    public static StatusTracker getInstance() {
        return ourInstance;
    }

    private StatusTracker() {
        mStatusMap = new LinkedHashMap<>();
        mMethodList = new ArrayList<>();
    }

    public void clear() {
        mMethodList.clear();
        mStatusMap.clear();
    }

    public void setStatus(String activityName, String status) {
        mMethodList.add(activityName + "." + status + "()");
        if (mStatusMap.containsKey(activityName)) {
            mStatusMap.remove(activityName);
            mStatusMap.put(activityName, status);
        }
    }

    public String getStatus(String activityName) {
        String status = mStatusMap.get(activityName);
        status = status.substring(2, status.length());

        if (status.endsWith("e")) {
            status = status.substring(0, status.length() - 1);
        }
        if (status.endsWith("p")) {
            status = status + "p";
        }
        status = status + STATUS_SUFFIX;
        return status;
    }

    public Set<String> keySet() {
        return mStatusMap.keySet();
    }

    public List<String> getMethodList() {
        return mMethodList;
    }
}
