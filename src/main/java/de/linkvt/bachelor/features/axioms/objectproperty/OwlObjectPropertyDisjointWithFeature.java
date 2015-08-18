package de.linkvt.bachelor.features.axioms.objectproperty;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectPropertyDisjointWithFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty hasSpouse = featurePool.getExclusiveProperty(":hasSpouse");
    OWLObjectProperty hasFavoriteMusicGenre = featurePool.getExclusiveProperty(":hasFavoriteMusicGenre");

    addAxiomToOntology(factory.getOWLDisjointObjectPropertiesAxiom(hasSpouse, hasFavoriteMusicGenre));

    addToGenericDomainAndNewRange(hasSpouse, featurePool.getExclusiveClass(":Wife"));
    addToGenericDomainAndNewRange(hasFavoriteMusicGenre, featurePool.getExclusiveClass(":DarkDiscoElectro"));
  }

  @Override
  public String getName() {
    return "owl:propertyDisjointWith (Object Property)";
  }

  @Override
  public String getToken() {
    return "propertydisjointwith";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_AXIOMS;
  }
}
