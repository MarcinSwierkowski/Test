package pl.sda.Party;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Party implements PartyList{

    private String partyName;
    private int maxMembers;
    private List<String> memberList = new ArrayList<>();
    private int actualMembersCount=0;

    public Party(String partyName, int maxMembers) {
        this.partyName = partyName;
        this.maxMembers = maxMembers;
    }

    @Override
    public void addPartyMembers() {
        TerminalInput terminalInput = new TerminalInput(memberList,maxMembers,partyName);
        memberList=terminalInput.podajImiona("dodaj");
        actualMembersCount=memberList.size();
    }

    @Override
    public void removePartyMembers() {
        TerminalInput terminalInput = new TerminalInput(memberList,maxMembers,partyName);
        memberList=terminalInput.podajImiona("usun");
        actualMembersCount=memberList.size();
    }

    @Override
    public boolean isPartyListFull() {
        if(memberList.size()==maxMembers) return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Party{" +
                "partyName='" + partyName + '\'' +
                ", maxMembers=" + maxMembers +
                ", memberList=" + memberList +
                ", actualMembersCount=" + actualMembersCount +
                '}';
    }
}
