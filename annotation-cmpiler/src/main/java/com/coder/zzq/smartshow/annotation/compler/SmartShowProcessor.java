package com.coder.zzq.smartshow.annotation.compler;

import com.coder.zzq.smartshow.annotations.SmartDialog;
import com.google.auto.service.AutoService;

import java.util.Collections;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

@AutoService(Processor.class)
public class SmartShowProcessor extends AbstractProcessor {
    private ProcessingEnvironment mProcessingEnvironment;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        mProcessingEnvironment = processingEnvironment;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(SmartDialog.class.getCanonicalName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        for (TypeElement typeElement : set) {
            switch (typeElement.getSimpleName().toString()) {
                case "SmartDialog":
                    processSmartDialogAnnotation(typeElement, roundEnvironment);
                    break;
            }
        }
        return true;
    }

    private void processSmartDialogAnnotation(TypeElement typeElement, RoundEnvironment roundEnvironment) {
        Set<? extends Element> annotatedClasses = roundEnvironment.getElementsAnnotatedWith(typeElement);
        for (Element annotatedClass : annotatedClasses) {
            String packageName = mProcessingEnvironment.getElementUtils().getPackageOf(annotatedClass).toString();
            String annotatedClassName = annotatedClass.getSimpleName().toString();

        }
    }
}