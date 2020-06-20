package pureinternational.something;

public class Info {
    String charName;
    String charSkill;
    String charWeb;
    int charPic;
    String charAddress;

    public Info(String charName, String charSkill, String charWeb, int charPic, String charAddress) {
        this.charName = charName;
        this.charSkill = charSkill;
        this.charWeb = charWeb;
        this.charPic = charPic;
        this.charAddress = charAddress;

    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getCharSkill() {
        return charSkill;
    }

    public void setCharSkill(String charSkill) {
        this.charSkill = charSkill;
    }

    public String getCharWeb() {
        return charWeb;
    }

    public void setCharWeb(String charWeb) {
        this.charWeb = charWeb;
    }

    public int getCharPic() {
        return charPic;
    }

    public void setCharPic(int charPic) {
        this.charPic = charPic;
    }

    public String getCharAddress() {
        return charAddress;
    }

    public void setCharAddress(String charAddress) {
        this.charAddress = charAddress;
    }
}


