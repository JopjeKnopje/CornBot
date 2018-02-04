package jopjeknopje.bot.cornbot.util;

import net.dv8tion.jda.core.entities.Member;

public class gasMember {

    private Member member;
    private boolean gas = false;

    public gasMember(Member member, boolean gas) {
        this.member = member;
        this.gas = gas;
    }
}
