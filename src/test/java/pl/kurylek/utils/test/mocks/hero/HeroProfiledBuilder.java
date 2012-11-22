package pl.kurylek.utils.test.mocks.hero;

import static pl.kurylek.utils.test.mocks.hero.HeroBuilder.aHero;
import pl.kurylek.utils.test.builders.Builder;

public class HeroProfiledBuilder extends Builder<HeroBuilder> {

    public static HeroBuilder aCaptainAmerica() {
	return aHero().withFirstName("Steve").withLastName("Rogers").withNickname("captainAmerica");
    }

    public static HeroBuilder aRedScull() {
	return aHero().withFirstName("Johann").withLastName("Schmidt").withNickname("redScull");
    }

    public static HeroBuilder anIronMan() {
	return aHero().withFirstName("Anthony").withLastName("Stark").withNickname("ironMan");
    }

    public static HeroBuilder aHulk() {
	return aHero().withFirstName("Bruce").withLastName("Banner").withNickname("hulk");
    }
}
