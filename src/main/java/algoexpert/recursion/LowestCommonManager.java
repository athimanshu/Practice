package algoexpert.recursion;

import java.util.*;

class LowestCommonManager {

    public static OrgChart getLowestCommonManager(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {

        return getOrgInfo(topManager,reportOne,reportTwo).lowestCommonManager;

    }
   public static OrgInfo getOrgInfo(OrgChart manager, OrgChart reportOne, OrgChart reportTwo){
        int numOfReports = 0;
        for(OrgChart directReport: manager.directReports) {
            OrgInfo orgInfo = getOrgInfo(directReport, reportOne, reportTwo);
            if (orgInfo.lowestCommonManager != null)
                return orgInfo;
            numOfReports += orgInfo.numImportantReports;
        }
        if(manager == reportOne || manager == reportTwo) numOfReports ++;
        OrgChart lowestCommonManager = numOfReports == 2 ? manager :null;
        OrgInfo newOrgInfo = new OrgInfo(lowestCommonManager,numOfReports);
        return newOrgInfo;
   }

    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }

    static class OrgInfo {
        public OrgChart lowestCommonManager;
        int numImportantReports;

        OrgInfo(OrgChart lowestCommonManager, int numImportantReports){
                this.lowestCommonManager = lowestCommonManager;
                this.numImportantReports = numImportantReports;
        }
    }
}
