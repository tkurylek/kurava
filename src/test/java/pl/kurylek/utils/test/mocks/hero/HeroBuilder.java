package pl.kurylek.utils.test.mocks.hero;

import pl.kurylek.utils.test.builders.Builder;

public class HeroBuilder extends Builder<Hero> {

    public static HeroBuilder aHero() {
	return new HeroBuilder();
    }

    public HeroBuilder withFirstName(String firstName) {
	getBuildedObject().setFirstName(firstName);
	return this;
    }

    public HeroBuilder withLastName(String lastName) {
	getBuildedObject().setLastName(lastName);
	return this;
    }

    public HeroBuilder withNickname(String nickname) {
	getBuildedObject().setNickname(nickname);
	return this;
    }

    public HeroBuilder withId(Long id) {
	getBuildedObject().setId(id);
	return this;
    }
}
