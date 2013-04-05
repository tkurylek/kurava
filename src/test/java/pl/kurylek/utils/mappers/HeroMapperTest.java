package pl.kurylek.utils.mappers;

import static org.fest.assertions.Assertions.assertThat;
import static pl.kurylek.utils.test.mocks.hero.HeroProfiledBuilder.aCaptainAmerica;

import org.junit.Test;

import pl.kurylek.utils.test.mocks.hero.Hero;

public class HeroMapperTest {

    @Test
    public void shouldMapHero() {
	// given
	Hero captainAmerica = aCaptainAmerica().build();
	Mapper<Hero, HeroSnapshot> heroMapper = new Mapper<Hero, HeroSnapshot>() {

	    @Override
	    protected MappingStrategy<Hero, HeroSnapshot> getMappingStrategy() {
		return new MappingStrategy<Hero, HeroSnapshot>() {

		    @Override
		    public void map(Hero source, HeroSnapshot target) {
			target.setId(source.getId());
			target.setName(source.getFirstName() + " " + source.getLastName());
		    }
		};
	    }
	};

	// when
	HeroSnapshot result = heroMapper.map(captainAmerica);

	// then
	assertThat(result.getId()).isEqualTo(captainAmerica.getId());
	assertThat(result.getName()).isEqualTo(
		captainAmerica.getFirstName() + " " + captainAmerica.getLastName());
    }
}
