package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlIrreflexivePropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty("parentOf");
    OWLClass range = featurePool.getExclusiveClass("IrreflexivePropertyRange");
    addToGenericDomainAndNewRange(property, range);

    addAxiomToOntology(factory.getOWLIrreflexiveObjectPropertyAxiom(property));
  }

  @Override
  public String getName() {
    return "owl:IrreflexiveProperty";
  }

  @Override
  public String getToken() {
    return "irreflexiveprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.PROPERTY;
  }
}
