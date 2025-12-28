def call(Map cfg) {
    sh """
      docker build -t ${cfg.image}:${cfg.tag} .
      aws ecr get-login-password --region ${cfg.region} |
      docker login --username AWS --password-stdin ${cfg.registry}
      docker push ${cfg.image}:${cfg.tag}
    """
}
