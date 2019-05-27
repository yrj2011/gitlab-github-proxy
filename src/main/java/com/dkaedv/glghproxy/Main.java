package com.dkaedv.glghproxy;

/**
 * @author yrj
 * @description: TODO
 * @date 2019/5/27 17:08
 */
public class Main {
    static String [][] params={
            {"gcr.io/jenkinsxio/prow/tide                                      "," v20190411-88a8176fb                                               "},
            {"mytide                                                           "," v1                                                                "},
            {"gcr.io/jenkinsxio/builder-maven                                  "," 0.1.451                                                           "},
            {"mybuildermaven                                                   "," v1                                                                "},
            {"my-mongodb                                                       "," v1                                                                "},
            {"gcr.io/kubernetes-helm/tiller                                    "," v2.14.0                                                           "},
            {"<none>                                                           "," <none>                                                            "},
            {"gcr.io/jenkinsxio/builder-maven-b                                "," v1                                                                "},
            {"gcr.io/jenkinsxio/builder-maven                                  "," <none>                                                            "},
            {"gcr.io/jenkinsxio/builder-go                                     "," 0.1.451                                                           "},
            {"jenkinsxio/jx                                                    "," 2.0.118                                                           "},
            {"jenkins/jenkins                                                  "," lts                                                               "},
            {"10.104.61.235:5000/bosybox                                       "," v1.0                                                              "},
            {"busybox                                                          "," latest                                                            "},
            {"mysql                                                            "," 5                                                                 "},
            {"gcr.io/jenkinsxio/builder-go                                     "," 0.1.437                                                           "},
            {"steveltn/https-portal                                            "," 1                                                                 "},
            {"jenkinsxio/jx                                                    "," 2.0.1                                                             "},
            {"gcr.io/jenkinsxio/prow/tide                                      "," <none>                                                            "},
            {"gcr.io/jenkinsxio/prow/deck                                      "," v20190411-88a8176fb                                               "},
            {"gcr.io/jenkinsxio/prow/sinker                                    "," v20190411-88a8176fb                                               "},
            {"gcr.io/jenkinsxio/prow/crier                                     "," v20190411-88a8176fb                                               "},
            {"gcr.io/jenkinsxio/prow/pipeline                                  "," v20190411-88a8176fb                                               "},
            {"gcr.io/jenkinsxio/prow/plank                                     "," v20190411-88a8176fb                                               "},
            {"gcr.io/jenkinsxio/prow/hook                                      "," v20190411-88a8176fb                                               "},
            {"gcr.io/jenkinsxio/prow/horologium                                "," v20190411-88a8176fb                                               "},
            {"k8s.gcr.io/kube-proxy                                            "," v1.14.1                                                           "},
            {"mirrorgooglecontainers/kube-proxy                                "," v1.14.1                                                           "},
            {"k8s.gcr.io/kube-apiserver                                        "," v1.14.1                                                           "},
            {"k8s.gcr.io/kube-scheduler-amd64                                  "," v1.11.1                                                           "},
            {"k8s.gcr.io/kube-scheduler                                        "," v1.14.1                                                           "},
            {"mirrorgooglecontainers/kube-scheduler                            "," v1.14.1                                                           "},
            {"k8s.gcr.io/kube-controller-manager                               "," v1.14.1                                                           "},
            {"mirrorgooglecontainers/kube-controller-manager                   "," v1.14.1                                                           "},
            {"gcr.io/abayer-jx-experiment/bash                                 "," v20190508-91b53326                                                "},
            {"yrj2012/bash-v20190508-91b53326                                  "," latest                                                            "},
            {"gcr.io/abayer-jx-experiment/entrypoint                           "," v20190508-91b53326                                                "},
            {"yrj2012/entrypoint-v20190508-91b53326                            "," latest                                                            "},
            {"jenkinsxio/jenkinsx                                              "," 0.0.53                                                            "},
            {"jenkinsxio/jx-app-jacoco                                         "," 0.0.123                                                           "},
            {"rawlingsj/builder-jx                                             "," wip34                                                             "},
            {"gcr.io/jenkinsxio/nexus                                          "," 0.1.7                                                             "},
            {"registry                                                         "," 2.6.2                                                             "},
            {"registry                                                         "," latest                                                            "},
            {"jenkinsxio/jx                                                    "," 1.3.965                                                           "},
            {"gcr.io/kaniko-project/executor                                   "," 9912ccbf8d22bbafbf971124600fbb0b13b9cbd6                          "},
            {"yrj2012/executor                                                 "," latest                                                            "},
            {"jenkinsxio/exposecontroller                                      "," 2.3.95                                                            "},
            {"gcr.io/abayer-jx-experiment/creds-init                           "," v20190508-91b53326                                                "},
            {"yrj2012/creds-init-v20190508-91b53326                            "," latest                                                            "},
            {"gcr.io/abayer-jx-experiment/creds-init                           "," v20190308-186ac3b6                                                "},
            {"gcr.io/abayer-jx-experiment/git-init                             "," v20190508-91b53326                                                "},
            {"yrj2012/git-init-v20190508-91b53326                              "," latest                                                            "},
            {"gcr.io/jenkinsxio/exposecontroller                               "," 2.3.110                                                           "},
            {"jenkinsxio/exposecontroller                                      "," 2.3.89                                                            "},
            {"quay.io/kubernetes-ingress-controller/nginx-ingress-controller   "," 0.22.0                                                            "},
            {"k8s.gcr.io/coredns                                               "," 1.3.1                                                             "},
            {"k8s.gcr.io/etcd                                                  "," 3.3.10                                                            "},
            {"mirrorgooglecontainers/etcd                                      "," 3.3.10                                                            "},
            {"jenkinsci/jnlp-slave                                             "," 3.26-1-alpine                                                     "},
            {"bitnami/mongodb                                                  "," 3.6.6-debian-9                                                    "},
            {"chartmuseum/chartmuseum                                          "," v0.7.1                                                            "},
            {"bitnami/monocular-ui                                             "," v0.7.3                                                            "},
            {"bitnami/monocular-api                                            "," v0.7.3                                                            "},
            {"gcr.io/kubernetes-helm/tiller                                    "," v2.9.1                                                            "},
            {"k8s.gcr.io/heapster                                              "," v1.5.2                                                            "},
            {"k8s.gcr.io/pause                                                 "," 3.1                                                               "},
            {"mirrorgooglecontainers/pause                                     "," 3.1                                                               "},
            {"registry.cn-hangzhou.aliyuncs.com/google_containers/pause-amd64  "," 3.1                                                               "},
            {"k8s.gcr.io/pause-amd64                                           "," 3.1                                                               "},
            {"k8s.gcr.io/defaultbackend                                        "," 1.4                                                               "},
            {"migmartri/prerender                                              "," latest                                                            "},
            {"k8s.gcr.io/addon-resizer                                         "," 1.7                                                               "},
            {"gcr.io/abayer-jx-experiment/nop                                  "," v20190508-91b53326                                                "},
            {"yrj2012/nop                                                      "," latest                                                            "},
            {"gcr.io/abayer-jx-experiment/webhook                              "," v20190508-91b53326                                                "},
            {"gcr.io/abayer-jx-experiment/controller                           "," v20190508-91b53326                                                "}
    };
    public static void main(String args[]){
        for(String[] i:params){
            String imageName = i[0];
            String version = i[1];
            if(imageName.contains("yrj")){
                continue;
            }
            if(version.contains("none")){
                continue;
            }
            imageName = imageName.trim();
            version = version.trim();
            String fileName = imageName+"-"+version;
            fileName =fileName.replaceAll("\\/","-").replaceAll("\\.","_");
            fileName += ".tar";
            System.out.println("docker save  " +  imageName.trim()+":"+version.trim() +"   -o  "+ fileName );
        }
    }
}
