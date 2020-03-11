/*
 * OpeartionManager
 * Create Date: 2020. 03. 10.
 * Copyright: SONY MUSIC ENTERTAINMENT
 * Initial-Author: barazakos
 */
package caras.operation;

import caras.metadata.BeanMetadata;
import caras.metadata.PropertyMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * @version $Revision$ $LastChangedDate$ 
 * @author $Author$
 */
public class OperationManager {

    public OperationManager instance() {
        return null; // gets the configured instance
    }

    public <_B> List<TypeOperation<_B>> getTypeOperations(BeanMetadata<_B> beanMetadata) {
        List<TypeOperationInfo<_B>> operations = beanMetadata.getTypeOperations();
        if (operations == null) {
            List<TypeOperationInfo<_B>> all = OperationRegistry.instance().getTypeOperations();
            operations = new ArrayList<>(all.size());

            for (int i = all.size(); --i >= 0; ) {
                TypeOperationInfo<_B> operation = all.get(i);
                if (operation.supports(beanMetadata))
                    operations.add(operation);
            }
            beanMetadata.setTypeOperations(operations);
        }

        ArrayList<TypeOperation<_B>> result = new ArrayList<>(operations.size());
        for (int i = operations.size(); --i >= 0; ) {
            TypeOperationInfo<_B> operation = operations.get(i);
            if (!operation.supports(beanMetadata))
                continue;

            TypeOperation<_B> opInstance = operation.createInstance();
            result.add(opInstance);
        }

        return result;
    }

    public <_B> List<BeanOperation<_B>> getBeanOperations(_B bean, BeanMetadata<_B> beanMetadata) {
        List<BeanOperationInfo<_B>> operations = beanMetadata.getBeanOperations();
        if (operations == null) {
            List<BeanOperationInfo<_B>> all = OperationRegistry.instance().getBeanOperations();
            operations = new ArrayList<>(all.size());

            for (int i = all.size(); --i >= 0; ) {
                BeanOperationInfo<_B> operation = all.get(i);
                if (operation.supports(beanMetadata))
                    operations.add(operation);
            }
            beanMetadata.setBeanOperations(operations);
        }

        ArrayList<BeanOperation<_B>> result = new ArrayList<>(operations.size());
        for (int i = operations.size(); --i >= 0; ) {
            BeanOperationInfo<_B> operation = operations.get(i);
            if (!operation.supports(bean))
                continue;

            BeanOperation<_B> opInstance = operation.createInstance(bean);
            result.add(opInstance);
        }

        return result;
    }

    public <_B, _P> List<PropertyOperation<_B, _P>> getPropertyOperations(_B bean, PropertyMetadata<_B, _P> propertyMetadata) {
        List<PropertyOperationInfo<_B, _P>> operations = propertyMetadata.getPropertyOperations();
        if (operations == null) {
            List<PropertyOperationInfo<_B, _P>> all = OperationRegistry.instance().getPropertyOperations();
            operations = new ArrayList<>(all.size());

            for (int i = all.size(); --i >= 0; ) {
                PropertyOperationInfo<_B, _P> operation = all.get(i);
                if (operation.supports(propertyMetadata))
                    operations.add(operation);
            }
            propertyMetadata.setPropertyOperations(operations);
        }

        ArrayList<PropertyOperation<_B, _P>> result = new ArrayList<>(operations.size());
        for (int i = operations.size(); --i >= 0; ) {
            PropertyOperationInfo<_B, _P> operation = operations.get(i);
            if (!operation.supports(bean))
                continue;

            PropertyOperation<_B, _P> opInstance = operation.createInstance(bean);
            result.add(opInstance);
        }

        return result;
    }
}
